import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupermarketGUI extends JFrame {
    private ShoppingCart cart;
    private JTextArea cartArea;
    private JTable productTable;
    private JTextField quantityField;
    private DefaultTableModel productTableModel;
    private JLabel totalLabel;

    public SupermarketGUI() {
        cart = new ShoppingCart();
        setTitle("Supermarket Billing System");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel productLabel = new JLabel("Available Products");
        String[] columnNames = {"Product Name", "Price", "Stock"};
        productTableModel = new DefaultTableModel(columnNames, 0);
        productTable = new JTable(productTableModel);
        JScrollPane productScrollPane = new JScrollPane(productTable);
        productScrollPane.setPreferredSize(new Dimension(600, 150));
        loadProductsIntoTable();

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        middlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel quantityLabel = new JLabel("Enter Quantity:");
        quantityField = new JTextField(5);
        JButton addButton = new JButton("Add to Cart");
        addButton.setToolTipText("Add selected product to the cart");
        addButton.addActionListener(new AddProductListener());

        JPanel inputPanel = new JPanel();
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(addButton);
        middlePanel.add(inputPanel);

        cartArea = new JTextArea(10, 40);
        cartArea.setEditable(false);
        cartArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane cartScrollPane = new JScrollPane(cartArea);
        cartScrollPane.setPreferredSize(new Dimension(600, 200));

        totalLabel = new JLabel("Total: ₹0.00");

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setToolTipText("Click to finalize the bill");
        checkoutButton.addActionListener(e -> checkout());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.add(cartScrollPane);
        bottomPanel.add(totalLabel);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        bottomPanel.add(checkoutButton);

        setLayout(new BorderLayout());
        add(productLabel, BorderLayout.NORTH);
        add(productScrollPane, BorderLayout.CENTER);
        add(middlePanel, BorderLayout.WEST);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void loadProductsIntoTable() {
        Product[] products = loadProducts();
        for (Product product : products) {
            productTableModel.addRow(new Object[]{product.getName(), "₹" + product.getPrice(), product.getQuantity()});
        }
    }

    private Product[] loadProducts() {
        return new Product[]{
                new Product("Apple", 1, 50, 100),
                new Product("Banana", 2, 30, 120),
                new Product("Milk", 3, 120, 50),
                new Product("Bread", 4, 20, 30),
                new Product("Orange", 5, 60, 80)
        };
    }

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
                        totalLabel.setText("Total: $" + cart.calculateTotal());
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

    private void checkout() {
        JOptionPane.showMessageDialog(this, formatReceipt(cart.getCartDetails()), "Final Bill", JOptionPane.INFORMATION_MESSAGE);
    }

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
