
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TiendaTec extends JFrame {

    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtStock;

    private DefaultTableModel modelo;
    private final Map<String, Producto> productos = new HashMap<>();

    public TiendaTec() {
        setTitle("TiendaTec - Registro de Productos");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel formulario = new JPanel(new GridLayout(4, 2, 10, 10));
        formulario.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        txtCodigo = new JTextField();
        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        txtStock = new JTextField();

        formulario.add(new JLabel("Código:"));
        formulario.add(txtCodigo);

        formulario.add(new JLabel("Nombre:"));
        formulario.add(txtNombre);

        formulario.add(new JLabel("Precio:"));
        formulario.add(txtPrecio);

        formulario.add(new JLabel("Stock:"));
        formulario.add(txtStock);

        modelo = new DefaultTableModel(
            new String[]{"Código", "Nombre", "Precio", "Stock"}, 0
        ) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        JTable tabla = new JTable(modelo);

        JButton btnRegistrar = new JButton("Registrar producto");
        JButton btnLimpiar = new JButton("Limpiar");

        btnRegistrar.addActionListener(e -> registrarProducto());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        JPanel botones = new JPanel();
        botones.add(btnRegistrar);
        botones.add(btnLimpiar);

        add(formulario, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
    }

    private void registrarProducto() {

        String codigo = txtCodigo.getText().trim()
                .toUpperCase(Locale.ROOT);
        String nombre = txtNombre.getText().trim();
        String precioTexto = txtPrecio.getText().trim();
        String stockTexto = txtStock.getText().trim();

        // CP03, CP04 y CP10: campos obligatorios
        if (codigo.isEmpty() || nombre.isEmpty()
                || precioTexto.isEmpty() || stockTexto.isEmpty()) {
            mostrarError("Todos los campos son obligatorios.");
            return;
        }

        // CP02: código duplicado
        if (productos.containsKey(codigo)) {
            mostrarError("El código ya existe.");
            return;
        }

        BigDecimal precio;
        int stock;

        // CP06: precio no numérico
        try {
            precio = new BigDecimal(
                precioTexto.replace(',', '.')
            );
        } catch (NumberFormatException e) {
            mostrarError("El precio debe ser numérico.");
            return;
        }

        // CP05: precio negativo
        if (precio.compareTo(BigDecimal.ZERO) < 0) {
            mostrarError("El precio no puede ser negativo.");
            return;
        }

        // CP08: stock decimal o no numérico
        try {
            stock = Integer.parseInt(stockTexto);
        } catch (NumberFormatException e) {
            mostrarError("El stock debe ser un número entero.");
            return;
        }

        // CP07: stock negativo
        if (stock < 0) {
            mostrarError("El stock no puede ser negativo.");
            return;
        }

        // CP01 y CP09: registro válido, incluido stock cero
        Producto producto = new Producto(
            codigo, nombre, precio, stock
        );

        productos.put(codigo, producto);

        modelo.addRow(new Object[]{
            producto.codigo,
            producto.nombre,
            producto.precio.toPlainString(),
            producto.stock
        });

        JOptionPane.showMessageDialog(
            this,
            "Producto registrado correctamente.",
            "Registro exitoso",
            JOptionPane.INFORMATION_MESSAGE
        );

        limpiarCampos();
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
            this,
            mensaje,
            "Error de validación",
            JOptionPane.ERROR_MESSAGE
        );
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtCodigo.requestFocus();
    }

    private static class Producto {
        String codigo;
        String nombre;
        BigDecimal precio;
        int stock;

        Producto(String codigo, String nombre,
                 BigDecimal precio, int stock) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TiendaTec().setVisible(true);
        });
    }
}
