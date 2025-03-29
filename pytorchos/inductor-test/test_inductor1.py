import torch

torch._inductor.config.debug = True  # Enable debug mode
torch._dynamo.config.verbose = True  # Verbose logging

@torch.compile()
def foo(x):
    print("Function executed")  # Add this line for confirmation
    return x * 2

x = torch.randn(10, 10, dtype=torch.float32, requires_grad=True)
result = foo(x)

print(result)  # Print the output tensor
