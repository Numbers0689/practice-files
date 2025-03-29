import torch
import torch.nn as nn
import torch.nn.functional as F
from torch._inductor import config

config.fallback_random = True
torch.set_grad_enabled(False)


class Model(torch.nn.Module):
    def __init__(self):
        super(Model, self).__init__()

    def forward(self, x):
        y = torch.tensor(0, dtype=torch.float64)  # y dtype: torch.float32
        x = torch.select_scatter(x, y, dim=0, index=0)
        return x


model = Model()

x = torch.Tensor([0]).to(torch.int32)

inputs = [x]


def run_test(model, inputs, backend):
    model.eval()
    torch.manual_seed(0)
    if backend != "eager":
        model = torch.compile(model, backend=backend)
    try:
        c_output = model(*inputs)
        print(c_output)
    except Exception as e:
        print(e)


run_test(model, inputs, 'eager')
run_test(model, inputs, 'inductor')
