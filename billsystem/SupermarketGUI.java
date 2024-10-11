import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class SupermarketGUI extends JFrame {
    private ShoppingCart cart;
    private JTextArea cartArea;
    private JTable productTable;
    private JTextField quantityField;
    private DefaultTableModel productTableModel;

    public SupermarketGUI() {
        cart = new ShoppingCart();
        setTitle("Supermarket Billing System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        JLabel productLabel = new JLabel("Available Products");
        JLabel quantityLabel = new JLabel("Enter Quantity:");

        // Product Table for better display
        String[] columnNames = {"Product Name", "Price", "Stock"};
        productTableModel = new DefaultTableModel(columnNames, 0);
        productTable = new JTable(productTableModel);
        JScrollPane productScrollPane = new JScrollPane(productTable);
        loadProductsIntoTable();  // Load products into JTable

        quantityField = new JTextField(5);
        JButton addButton = new JButton("Add to Cart");
        addButton.setToolTipText("Add selected product to the cart");
        addButton.addActionListener(new AddProductListener());

        cartArea = new JTextArea(15, 40);
        cartArea.setEditable(false);
        cartArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane cartScrollPane = new JScrollPane(cartArea);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setToolTipText("Click to finalize the bill");
        checkoutButton.addActionListener(e -> checkout());

        // Layout setup
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(productLabel);
        topPanel.add(productScrollPane);

        JPanel quantityPanel = new JPanel();
        quantityPanel.add(quantityLabel);
        quantityPanel.add(quantityField);
        quantityPanel.add(addButton);

        JPanel cartPanel = new JPanel();
        cartPanel.add(cartScrollPane);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(checkoutButton);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(quantityPanel, BorderLayout.CENTER);
        add(cartPanel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // Load products into JTable
    private void loadProductsIntoTable() {
        Product[] products = loadProducts();
        for (Product product : products) {
            productTableModel.addRow(new Object[]{product.getName(), "$" + product.getPrice(), product.getQuantity()});
        }
    }

    // Load product array
    private Product[] loadProducts() {
        return new Product[]{
                new Product("Apple", 1, 0.50, 100),
                new Product("Banana", 2, 0.30, 120),
                new Product("Milk", 3, 1.20, 50),
                new Product("Bread", 4, 2.00, 30),
                new Product("Orange", 5, 0.60, 80)
        };
    }

    // Listener for adding products to the cart
    private class AddProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow != -1) {
                String productName = (String) productTableModel.getValueAt(selectedRow, 0);
                double productPrice = Double.parseDouble(productTableModel.getValueAt(selectedRow, 1).toString().substring(1));
                int productStock = Integer.parseInt(productTableModel.getValueAt(selectedRow, 2).toString());

                Product selectedProduct = new Product(productName, selectedRow, productPrice, productStock);
                try {
                    int quantity = Integer.parseInt(quantityField.getText());
                    if (quantity <= selectedProduct.getQuantity()) {
                        cart.addProduct(selectedProduct, quantity);
                        cartArea.setText(cart.getCartDetails());
                        productTableModel.setValueAt(productStock - quantity, selectedRow, 2);  // Update stock
                    } else {
                        JOptionPane.showMessageDialog(SupermarketGUI.this, "Not enough stock available!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SupermarketGUI.this, "Please enter a valid quantity.");
                }
            } else {
                JOptionPane.showMessageDialog(SupermarketGUI.this, "Please select a product.");
            }
        }
    }

    // Checkout and display the total bill
    private void checkout() {
        JOptionPane.showMessageDialog(this, formatReceipt(cart.getCartDetails()), "Final Bill", JOptionPane.INFORMATION_MESSAGE);
    }

    // Format the receipt to look nicer
    private String formatReceipt(String cartDetails) {
        StringBuilder formatted = new StringBuilder();
        formatted.append("----------------------------\n");
        formatted.append("          FINAL BILL        \n");
        formatted.append("----------------------------\n");
        formatted.append(cartDetails);
        formatted.append("\n----------------------------\n");
        formatted.append("Thank you for shopping!");
        return formatted.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SupermarketGUI gui = new SupermarketGUI();
            gui.setVisible(true);
        });
    }
}
