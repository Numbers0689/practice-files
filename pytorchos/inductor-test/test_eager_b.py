import torch

torch.set_grad_enabled(False)

class Model(torch.nn.Module):
    def __init__(self):
        super(Model, self).__init__()

    def forward(self, x):
        y = torch.tensor([0.0], dtype=torch.bool)  # y is float16
        x = torch.slice_scatter(y, x, 0)  # Try to scatter x (int) into y (float)
        return x

model = Model()

# Test with different dtypes for x
dtypes = [torch.int8, torch.int16, torch.int32, torch.int64, 
          torch.uint8, torch.uint16, torch.uint32, torch.uint64]

for dtype in dtypes:
    try:
        x = torch.tensor([2], dtype=dtype)  # x has an integer dtype
        output = model(x)
        print(f"Eager succeeded: x.dtype={x.dtype}, output.dtype={output.dtype}, output={output}")
    except Exception as e:
        print(f"Eager failed for dtype {dtype}: {e}")
