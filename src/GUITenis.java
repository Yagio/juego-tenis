import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Yagio on 13/07/14.
 */
public class GUITenis {

    private JPanel mainPanel;
    private JLabel idiomaLabel;
    private JComboBox idiomacomboBox;
    private JTable marcadorTable;
    private JLabel marcadorLabel;
    private JButton jugador1Button;
    private JButton jugador2Button;
    private JLabel jugadoresLabel;
    private JPanel idiomasPanel;
    private JPanel marcadorPanel;
    private JPanel jugadoresPanel;
    private JScrollPane scrollTable;
    private String jugador1 = "Juan";
    private String jugador2 = "Pedro";
    DefaultTableModel model = new DefaultTableModel();
    Tenis t = new Tenis(jugador1, jugador2);

    public GUITenis() {

        crearTabla();

        idiomacomboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = idiomacomboBox.getSelectedItem().toString();
                t.setIdioma(value);
            }
        });

        jugador1Button.setText(jugador1);
        jugador1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregar_marcador(jugador1);
            }
        });

        jugador2Button.setText(jugador2);
        jugador2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               agregar_marcador(jugador2);
            }
        });
        marcadorTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = marcadorTable.getSelectedRow();
                int puntos_jugador1 = (Integer) marcadorTable.getValueAt(row, 0);
                int puntos_jugador2 = (Integer) marcadorTable.getValueAt(row, 1);
                String score = (String) marcadorTable.getValueAt(row,2);

                t.cambiar_punto(jugador1, puntos_jugador1);
                t.cambiar_punto(jugador2, puntos_jugador2);

                marcadorLabel.setText(t.generar_marcador());

                int tamano = marcadorTable.getRowCount();
                int inicio = row+1;
                for(int xx= inicio  ; xx < tamano  ; xx++){
                    DefaultTableModel modelo = (DefaultTableModel)marcadorTable.getModel();
                    modelo.removeRow(row+1);
                }
            }
        });
    }

    public void crearTabla(){
        marcadorTable = new JTable(model);

        model.addColumn("Puntos de "+jugador1);
        model.addColumn("Puntos de "+jugador2);
        model.addColumn("Marcador");

        marcadorTable.setPreferredScrollableViewportSize(new Dimension(400, 100));
        scrollTable.setViewportView(marcadorTable);
    }

    public void agregar_marcador(String nombre_jugador){
        int puntos_jugador1;
        int puntos_jugador2;
        String marcador;
        t.punto_ganado(nombre_jugador);
        puntos_jugador1 = t.obtener_puntaje(jugador1);
        puntos_jugador2 = t.obtener_puntaje(jugador2);
        marcador = t.generar_marcador();

        marcadorLabel.setText(marcador);
        model.addRow(new Object[]{puntos_jugador1, puntos_jugador2, marcador});

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUITenis");
        frame.setContentPane(new GUITenis().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
