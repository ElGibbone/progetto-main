import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

// *Chen: I commenti li ho messi per capire meglio non è sempre lavoro da me compiuto le parti commentati


public class Gui_magazzino extends JFrame implements ActionListener{
    // attributi 
    private Negozio negozio;
    private ArrayList<JButton> listaBottoni;
    private ArrayList<JTextField> listaCampiInputOutput;
    private JLabel nome;
    private JButton indietro;        //TODO Pulsante indietro da fare
    private JPanel panelloProdotti;
    private JPanel panelloInput;
    private JPanel panelloSotto;
    private JPanel panelloSopra;
    private JPanel panellone;
    private GridLayout layoutBottoni;
    private GridLayout layoutOutput;
    private GridLayout layoutSopra;
    private GridLayout layoutSotto;
    private GridLayout layoutGrande;
    // costruttore 
    public Gui_magazzino(Negozio negozio) {

        // Configurazione iniziale finestra
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(false);
        this.setTitle("Gestione ordini");

        this.negozio = negozio; 
        layoutBottoni = new GridLayout(5,5);    /* *Chen zona bottoni con prodotti da ordinare */
        layoutOutput = new GridLayout(5,1);     /* *Chen zona text field da mettere i input e vedere output*/
        layoutSopra = new GridLayout(1,2);      
        layoutSotto = new GridLayout(1,2);
        layoutGrande = new GridLayout(2,1);
        panelloProdotti = new JPanel(layoutBottoni);
        listaBottoni = new ArrayList<>();
        creazionebottoni();
        listaCampiInputOutput = new ArrayList<>();
        panelloInput = new JPanel(layoutOutput);
        crezioneJTF();
        panelloSotto = new JPanel(layoutSotto);
        panelloSotto.add(panelloProdotti);
        panelloSotto.add(panelloInput);
        nome = new JLabel("magazzino");
        indietro = new JButton("indietro");
        panelloSopra = new JPanel(layoutSopra);
        panelloSopra.add(nome);
        panelloSopra.add(indietro);
        panellone = new JPanel(layoutGrande);
        panellone.add(panelloSopra);
        panellone.add(panelloSotto);
        add(panellone);
        
        

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    // metodi 
    @Override
public void actionPerformed(ActionEvent e) {
    /**
     *Chen:
        Idea di cliccare il bottone della materia prima e far comparire nei TextField input da inserire per riordinare.
        sono scarso con programmazione con grafica e non so come fare
    **/ 
}
    public void creazionebottoni(){
        for (ProdottoUsato p : negozio.loadMagazzino()) {
            // *Chen piccola modifica dal prendere tutto il menu a prendere solo le materie prime per il negozio come pane ecc... 
            JButton bottone = new JButton(p.getProdotto().getNome());
            /* *Chen
             * altrimenti il codice vecchio 
            for (Prodotto p : negozio.getMenu()) {
            JButton bottone = new JButton(p.getNome());
             */
            listaBottoni.add(bottone);
            panelloProdotti.add(bottone);
        }
    }
    public void crezioneJTF(){
        for (int i = 0; i < 4; i++) { // *Chen da 5 a 4 perché abbiamo 4 e non 5 tipi di in/out put (se non sbaglio) 
            JTextField area = new JTextField(10); 
            listaCampiInputOutput.add(area);
            panelloInput.add(area);
        }
        // Imposta il testo predefinito per ciascun JTextField nell'ArrayList
        // *Chen: ho messo questo per capire meglio quando è avviato il programma
        for (int i = 0; i < listaCampiInputOutput.size(); i++) {
            JTextField textField = listaCampiInputOutput.get(i);
            switch (i) {
                case 0:
                textField.setText("nome prodotto(outpout)");
                    break;
                case 1:
                textField.setText("numero prodotti rimasti(outpout)");
                    break;
                case 2:
                textField.setText("numero di prodotti ordinati l'ultima volta(outpout)");
                    break;
                case 3:
                textField.setText("quantità da ordinare(input)");
                    break;
            
                default:
                    break;
                }
        }

    }
}

