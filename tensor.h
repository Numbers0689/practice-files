typedef int TensorShape[4];
typedef struct GradNode GradNode;

typedef struct FloatBuffer {
    int numel;
    float flex[];
} FloatBuffer;

typedef struct Tensor {
    TensorShape shape;
    FloatBuffer* data;
    GradNode* node;
} Tensor;

typedef struct GradNode {
    struct Tensor grad;
    struct Tensor (*grad_fn)(struct Tensor self, int i);
    struct Tensor inputs[4];
    int n_inputs;
} GradNode;

/* Basic Tensor Operations */
// Elementwise Operations
// Corresponding gradient functions as well
Tensor Tensor_add(Tensor self, Tensor other);
Tensor Tensor_sub(Tensor self, Tensor other);
Tensor Tensor_mul(Tensor self, Tensor other);
Tensor Tensor_div(Tensor self, Tensor other);
Tensor Tensor_pow(Tensor self, Tensor other);

Tensor Tensor_addf(Tensor self, float other);
Tensor Tensor_subf(Tensor self, float other);
Tensor Tensor_mulf(Tensor self, float other);
Tensor Tensor_divf(Tensor self, float other);
Tensor Tensor_powf(Tensor self, float other);

Tensor Tensor_matmul(Tensor self, Tensor other);
Tensor Tensor_transpose(Tensor self, int dim0, int dim1);

/* Advanced Math Operations */
Tensor Tensor_mod(Tensor self, Tensor other);
Tensor Tensor_clamp(Tensor self, float min_val, float max_val);
Tensor Tensor_sqrt(Tensor self);
Tensor Tensor_exp(Tensor self);
Tensor Tensor_log1p(Tensor self);
Tensor Tensor_norm(Tensor self, float p);
Tensor Tensor_logsumexp(Tensor self);

/* Logical Operations - if necessary? */
Tensor Tensor_eq(Tensor self, Tensor other);
Tensor Tensor_neq(Tensor self, Tensor other);
Tensor Tensor_gt(Tensor self, Tensor other);
Tensor Tensor_lt(Tensor self, Tensor other);

/* Unary Operations */
Tensor Tensor_neg(Tensor self);
Tensor Tensor_abs(Tensor self);

/* Reduction Operations */
Tensor Tensor_sum(Tensor self);
Tensor Tensor_mean(Tensor self);
Tensor Tensor_max(Tensor self);
Tensor Tensor_min(Tensor self);
Tensor Tensor_var(Tensor self);
Tensor Tensor_std(Tensor self);

void Tensor_argmax(Tensor self, int* out);

/* Initialization Functions */
Tensor Tensor_ones(TensorShape shape, bool requires_grad);
Tensor Tensor_zeros(TensorShape shape, bool requires_grad);
Tensor Tensor_rand(TensorShape shape, bool requires_grad);
Tensor Tensor_randn(TensorShape shape, bool requires_grad);
Tensor Tensor_xavier(TensorShape shape, bool requires_grad);
Tensor Tensor_he(TensorShape shape, bool requires_grad);

/* Utility Functions */
Tensor Tensor_flatten(Tensor self);
Tensor Tensor_reshape(Tensor self, int* shape, int ndim);
Tensor Tensor_permute(Tensor self, int* dims, int ndim);

/* Neural Network functoins, layers, activations and loss functions*/
Tensor nn_log(Tensor self);
Tensor nn_exp(Tensor self);
Tensor nn_sin(Tensor self);
Tensor nn_cos(Tensor self);
Tensor nn_tan(Tensor self);

Tensor nn_linear(Tensor input, Tensor weight, Tensor bias);
Tensor nn_relu(Tensor input);
Tensor nn_leaky_relu(Tensor input, float negative_slope);
Tensor nn_elu(Tensor input, float alpha);
Tensor nn_sigmoid(Tensor input);
Tensor nn_tanh(Tensor input);
Tensor nn_softmax(Tensor input);

Tensor nn_crossentropy(Tensor y_true, Tensor y_pred);
Tensor nn_mse_loss(Tensor y_true, Tensor y_pred);
Tensor nn_mae_loss(Tensor y_true, Tensor y_pred);
Tensor nn_hinge_loss(Tensor y_true, Tensor y_pred);

/* Normalization Layers */
Tensor nn_batchnorm(Tensor input, Tensor gamma, Tensor beta, float eps);

/* Regularization */
Tensor nn_dropout(Tensor input, float prob);

/* Optimizers */
typedef struct optim_sgd {
    int n_params;
    Tensor* params;
    Tensor* grads;
    float lr;
    float momentum;
} optim_sgd;

optim_sgd* optim_sgd_new(int n_params, Tensor* params);
void optim_sgd_config(optim_sgd* self, float lr, float momentum);
void optim_sgd_zerograd(optim_sgd* self);
void optim_sgd_step(optim_sgd* self);
void optim_sgd_delete(optim_sgd* self);

/* Adam Optimizer */
typedef struct optim_adam {
    int n_params;
    Tensor* params;
    Tensor* grads;
    Tensor* m; // first moment estimate
    Tensor* v; // second moment estimate
    float lr;
    float beta1;
    float beta2;
    float eps;
} optim_adam;

optim_adam* optim_adam_new(int n_params, Tensor* params);
void optim_adam_config(optim_adam* self, float lr, float beta1, float beta2, float eps);
void optim_adam_zerograd(optim_adam* self);
void optim_adam_step(optim_adam* self);
void optim_adam_delete(optim_adam* self);

/* RMSprop Optimizer - if we do deep NN*/
typedef struct optim_rmsprop {
    int n_params;
    Tensor* params;
    Tensor* grads;
    Tensor* sq_avg;
    float lr;
    float alpha;
    float eps;
} optim_rmsprop;

optim_rmsprop* optim_rmsprop_new(int n_params, Tensor* params);
void optim_rmsprop_config(optim_rmsprop* self, float lr, float alpha, float eps);
void optim_rmsprop_zerograd(optim_rmsprop* self);
void optim_rmsprop_step(optim_rmsprop* self);
void optim_rmsprop_delete(optim_rmsprop* self);