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
    private JTextField jugador1TextField;
    private JTextField jugador2TextField;
    private JPanel marcador2Panel;
    private JTable marcador2Table;
    private JScrollPane marcador2Scroll;
    private JLabel idioma2Label;
    private JComboBox idioma2comboBox;
    private String jugador1 = "Jugador1";
    private String jugador2 = "Jugador2";
    private String idioma1 = "Español";
    private String idioma2 =  "Ingles";
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    Tenis t = new Tenis(jugador1, jugador2);

    public GUITenis() {


        crearTabla();

        idiomacomboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = idiomacomboBox.getSelectedItem().toString();
                idioma1 = value;
                //t.setIdioma(value);
            }
        });

        idioma2comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = idioma2comboBox.getSelectedItem().toString();
                idioma2 = value;
                //t.setIdioma(value);
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
                eliminar_row();
            }
        });


        jugador1TextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                t.setNombre_jugador1(jugador1TextField.getText());
                jugador1 = t.getNombre_jugador1();
                jugador1Button.setText(jugador1);
                marcadorTable.getColumnModel().getColumn(0).setHeaderValue("Puntos de " + jugador1);
                marcador2Table.getColumnModel().getColumn(0).setHeaderValue("Puntos de " + jugador1);
            }
        });

        jugador2TextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                t.setNombre_jugador2(jugador2TextField.getText());
                jugador2 = t.getNombre_jugador2();
                jugador2Button.setText(jugador2);
                marcadorTable.getColumnModel().getColumn(1).setHeaderValue("Puntos de " + jugador2);
                marcador2Table.getColumnModel().getColumn(1).setHeaderValue("Puntos de " + jugador2);
            }
        });
    }

    public void crearTabla(){
        marcadorTable = new JTable(model);
        marcador2Table = new JTable(model2);

        model.addColumn("Puntos de "+jugador1);
        model.addColumn("Puntos de "+jugador2);
        model.addColumn("Marcador");

        model2.addColumn("Puntos de "+jugador1);
        model2.addColumn("Puntos de "+jugador2);
        model2.addColumn("Marcador");

        marcadorTable.setPreferredScrollableViewportSize(new Dimension(400, 100));
        marcador2Table.setPreferredScrollableViewportSize(new Dimension(400, 100));
        scrollTable.setViewportView(marcadorTable);
        marcador2Scroll.setViewportView(marcador2Table);
    }

    public void agregar_marcador(String nombre_jugador){
        int puntos_jugador1;
        int puntos_jugador2;
        String marcador;
        t.punto_ganado(nombre_jugador);
        puntos_jugador1 = t.obtener_puntaje(jugador1);
        puntos_jugador2 = t.obtener_puntaje(jugador2);
        t.setIdioma(idioma1);
        marcador = t.generar_marcador();

        marcadorLabel.setText(marcador);
        model.addRow(new Object[]{puntos_jugador1, puntos_jugador2, marcador});

        t.setIdioma(idioma2);
        //model2.insertRow(0,new Object[]{puntos_jugador1, puntos_jugador2, t.generar_marcador()});
        model2.addRow(new Object[]{puntos_jugador1, puntos_jugador2, t.generar_marcador()});
    }

    public void eliminar_row(){
        int row = marcadorTable.getSelectedRow();
        int tamano = marcadorTable.getRowCount();
        int inicio = row + 1;
        int puntos_jugador1 = (Integer) marcadorTable.getValueAt(row, 0);
        int puntos_jugador2 = (Integer) marcadorTable.getValueAt(row, 1);
        String score = (String) marcadorTable.getValueAt(row,2);

        t.cambiar_punto(jugador1, puntos_jugador1);
        t.cambiar_punto(jugador2, puntos_jugador2);

        marcadorLabel.setText(score);

        for(int x = inicio; x < tamano; x++){
            DefaultTableModel modelo = (DefaultTableModel)marcadorTable.getModel();
            modelo.removeRow(inicio);
        }
    }

    public static void main(String[] args) {
        GUITenis gi = new GUITenis();
        JFrame frame = new JFrame("Jugadores");
        frame.setContentPane(gi.jugadoresPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(100,100);
        frame.setVisible(true);

        JFrame frame2 = new JFrame("Marcador");
        frame2.setContentPane(gi.marcadorPanel);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setLocation(500,100);
        frame2.setVisible(true);

        JFrame frame3 = new JFrame("Marcador Inverso");
        frame3.setContentPane(gi.marcador2Panel);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.pack();
        frame3.setLocation(500,300);
        frame3.setVisible(true);
    }
}
