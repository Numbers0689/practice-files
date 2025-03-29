import torch
import pytest
from torch._inductor import config

config.fallback_random = True
torch.set_grad_enabled(False)

class Model(torch.nn.Module):
    def forward(self, x):
        y = torch.tensor(0, dtype=torch.uint32)  # A scalar, not a full tensor
        x = torch.select_scatter(x, y, dim=0, index=0)  # Proper index-based scatter
        return x


@pytest.mark.parametrize("dtype", [
    torch.int8, torch.int16, torch.int32, torch.int64,
    torch.uint8, torch.uint16, torch.uint32, torch.uint64
])
def test_select_scatter_dtype_consistency(dtype):
    model = Model()
    x = torch.tensor([0], dtype=dtype)

    # Run with Eager mode
    eager_output = model(x)

    # Run with Inductor
    compiled_model = torch.compile(model, backend="inductor")
    try:
        inductor_output = compiled_model(x)
    except Exception as e:
        pytest.fail(f"Inductor failed for dtype {dtype}: {e}")

    # Ensure values match
    assert torch.allclose(eager_output, inductor_output), f"Value mismatch for dtype {dtype}"

    # Ensure dtype matches
    assert eager_output.dtype == inductor_output.dtype, f"Dtype mismatch for {dtype}: {eager_output.dtype} vs {inductor_output.dtype}"

if __name__ == "__main__":
    pytest.main([__file__])
