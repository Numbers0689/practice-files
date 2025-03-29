import torch
import pytest
from torch._inductor import config

config.fallback_random = True
torch.set_grad_enabled(False)

class Model(torch.nn.Module):
    def forward(self, x):
        y = torch.Tensor([0])  # float32
        x = torch.slice_scatter(y, x, 0)
        return x

@pytest.mark.parametrize("dtype", [torch.int8, torch.int16, torch.int32, torch.int64,
                                   torch.uint8, torch.uint16, torch.uint32, torch.uint64])
def test_slice_scatter_dtype_consistency(dtype):
    model = Model()
    x = torch.tensor([0], dtype=dtype)  # Create tensor of given dtype

    # Run with Eager
    eager_output = model(x)

    # Run with Inductor
    compiled_model = torch.compile(model, backend="inductor")
    inductor_output = compiled_model(x)

    # Ensure values match
    assert torch.allclose(eager_output, inductor_output), f"Value mismatch for dtype {dtype}"

    # Ensure dtype matches (Inductor should follow Eager's behavior)
    assert eager_output.dtype == inductor_output.dtype, f"Dtype mismatch for {dtype}: {eager_output.dtype} vs {inductor_output.dtype}"

# Run the test
if __name__ == "__main__":
    pytest.main([__file__])
