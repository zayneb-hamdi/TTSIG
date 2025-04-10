import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.util.List;

import org.openstreetmap.gui.jmapviewer.*;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;
//import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource.Mapnik;

import RMIChat.ChatGUI;

public class SIGWindow extends JFrame{
    JPanel panelLeft,panelRight,panelImage,panelMap,panelButtons,panelCouches;
    JMapViewer jMapViewer;
    JButton buttonTelecharger,buttonImporter,buttonAjouter,buttonSupprimer,buttonModifier,buttonRechercher,buttonFichier,buttonChat;
    JLabel labelId,labelNom,labelLongitude,labelLatitude,labelTitre,labelFichier,labelImage,labelCouches;
    JTextField fieldId,fieldNom,fieldLongitude,fieldLatitude;
    ImageIcon icon;
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollpane;
    String username;
    
    public SIGWindow( String username)
    {
        this.setTitle("TTSIG");
        this.setSize(1400,710);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.username=username;
        

        //declarations des composants
        panelLeft=new JPanel();
        panelRight=new JPanel();
        panelImage=new JPanel();
        panelMap=new JPanel();
        panelButtons=new JPanel();
        panelCouches=new JPanel();








        buttonImporter=new JButton("importer une carte");
        buttonTelecharger=new JButton("telecharger cette carte");
        buttonAjouter=new JButton("Ajouter");
        buttonFichier=new JButton("choisir fichier");
        buttonChat=new JButton("joindre la discussion");
        buttonSupprimer=new JButton("supprimer");
        buttonModifier=new JButton("modifier");
        buttonRechercher=new JButton("rechercher");









        icon=new ImageIcon("TTSIG\\lib\\chat.jpg");

        labelId=new JLabel("ID:");
        labelNom=new JLabel("nom:");
        labelLatitude=new JLabel("latitude:");
        labelLongitude=new JLabel("longitude:");
        labelTitre=new JLabel("ajouter une couche");
        labelFichier=new JLabel("ajouter à partir d'un fichier");
        labelImage=new JLabel(icon);
        labelCouches=new JLabel("Tableau de Couches");



        fieldId=new JTextField();
        fieldNom=new JTextField();
        fieldLatitude=new JTextField();
        fieldLongitude=new JTextField();

        model=new DefaultTableModel(new Object[]{"id","nom","latitude","longitude"},0){
           
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
        };
        table=new JTable(model);
        scrollpane=new JScrollPane(table);


        




        //coordonnees des composants
        panelLeft.setBounds(10,10,400,650);
        panelRight.setBounds(430,10,330,400);
        panelImage.setBounds(430,420,330,240);
        panelMap.setBounds(20,20,360,310);
        panelButtons.setBounds(205,80,120,180);
        panelCouches.setBounds(780,10,570,650);




        labelId.setBounds(20,80,100,20);
        labelNom.setBounds(20,130,100,20);
        labelLatitude.setBounds(20,180,100,20);
        labelLongitude.setBounds(20,230,100,20);
        labelTitre.setBounds(110,20,200,20);
        labelFichier.setBounds(90,300,300,20);
        labelImage.setBounds(90,20,150,150);
        labelCouches.setBounds(220,20,200,20);





        fieldId.setBounds(100,80,100,30);
        fieldNom.setBounds(100,130,100,30);
        fieldLatitude.setBounds(100,180,100,30);
        fieldLongitude.setBounds(100,230,100,30);







        buttonImporter.setBounds(50,400,300,50);
        buttonTelecharger.setBounds(50,470,300,50);
        buttonFichier.setBounds(95,330,150,30);
        buttonChat.setBounds(65,190,200,30);
        buttonAjouter.setBounds(10,10,100,30);
        buttonModifier.setBounds(10,50,100,30);
        buttonSupprimer.setBounds(10,90,100,30);
        buttonRechercher.setBounds(10,130,100,30);


    
        scrollpane.setBounds(35,50,500,500);

        







        //ajout des composants
        this.add(panelLeft);
        this.add(panelRight);
        this.add(panelImage);
        this.add(panelCouches);
        panelLeft.setLayout(null);
        panelLeft.add(panelMap);
        panelLeft.add( buttonImporter);
        panelLeft.add( buttonTelecharger);
        panelRight.setLayout(null);
        panelRight.add( labelId);
        panelRight.add( labelNom);
        panelRight.add( labelLatitude);
        panelRight.add( labelLongitude);
        panelRight.add( fieldId);
        panelRight.add(fieldNom);
        panelRight.add( fieldLatitude);
        panelRight.add( fieldLongitude);
        panelRight.add(labelTitre);
        panelRight.add( labelFichier);
        panelRight.add( buttonFichier);
        panelImage.setLayout( null);
        panelImage.add( labelImage);
        panelImage.add( buttonChat);
        panelRight.add( panelButtons);
        panelButtons.setLayout( null);
        panelButtons.add( buttonAjouter);
        panelButtons.add( buttonModifier);
        panelButtons.add( buttonSupprimer);
        panelButtons.add( buttonRechercher);
        panelCouches.setLayout( null);
        panelCouches.add(labelCouches);
        panelCouches.add(scrollpane);







        //mise en forme des composants
        panelLeft.setBackground(Color.gray);
        panelRight.setBorder(new LineBorder(new Color(101, 184, 255),2));
        panelImage.setBorder(new LineBorder(new Color(101, 184, 255),2));
        panelMap.setBorder(new LineBorder(new Color(101, 184, 255),3));
        labelImage.setBorder(new LineBorder(new Color(101, 184, 255),2));
        panelButtons.setBorder(new LineBorder(new Color(101, 184, 255),1));
        labelTitre.setForeground(new Color(101, 184, 255));
        panelCouches.setBorder(new LineBorder(new Color(101, 184, 255),2));
        labelCouches.setForeground(new Color(101, 184, 255));



        //jmapviewer setup
        jMapViewer=new JMapViewer();
        jMapViewer.setTileSource( new OsmTileSource.Mapnik());
        jMapViewer.setDisplayPosition(new Coordinate(35.03823, 9.48494),10);
        jMapViewer.setPreferredSize(new Dimension(320,290));
        panelMap.add( jMapViewer);
    


   

        updateData();
        addevents();


        this.setVisible(true);
        


    
    }

    public void addevents()
    {
        buttonAjouter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    LayerManager layerManager=new LayerManager();
                    int id;
                   if (fieldId.getText().isEmpty()) {
                    id=0;
                    
                   } else {
                    id=Integer.parseInt(fieldId.getText());
                   }

                   String nom;
                   if (fieldNom.getText().isEmpty()) {
                    nom="";
                   } else {
                    nom=fieldNom.getText();
                    
                   }
                   double latitude;
                   if (fieldLatitude.getText().isEmpty()) {
                    latitude=0;
                    
                   } else {
                    latitude=Double.parseDouble(fieldLatitude.getText());
                    
                   }
                   double longitude;
                   if (fieldLongitude.getText().isEmpty()) {
                    longitude=0;
                    
                   } else {
                    longitude=Double.parseDouble(fieldLongitude.getText());
                   }
                   layerManager.ajouterLayer(new Layer(id, nom, latitude, longitude));
                   updateData();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    System.out.println("erreur d'ajout");
                }
                
            }
            
        });

        buttonModifier.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    LayerManager layerManager=new LayerManager();
                    int id;
                   if (fieldId.getText().isEmpty()) {
                    id=0;
                    
                   } else {
                    id=Integer.parseInt(fieldId.getText());
                   }

                   String nom;
                   if (fieldNom.getText().isEmpty()) {
                    nom="";
                   } else {
                    nom=fieldNom.getText();
                    
                   }
                   double latitude;
                   if (fieldLatitude.getText().isEmpty()) {
                    latitude=0;
                    
                   } else {
                    latitude=Double.parseDouble(fieldLatitude.getText());
                    
                   }
                   double longitude;
                   if (fieldLongitude.getText().isEmpty()) {
                    longitude=0;
                    
                   } else {
                    longitude=Double.parseDouble(fieldLongitude.getText());
                   }
                   layerManager.modifierLayer(new Layer(id, nom, latitude, longitude));
                   updateData();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    System.out.println("erreur de modification");
                }
            }
            
        });
        buttonSupprimer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    LayerManager layerManager=new LayerManager();
                    int id;
                   if (fieldId.getText().isEmpty()) {
                    id=0;
                    
                   } else {
                    id=Integer.parseInt(fieldId.getText());
                   }

                   String nom;
                   if (fieldNom.getText().isEmpty()) {
                    nom="";
                   } else {
                    nom=fieldNom.getText();
                    
                   }
                   double latitude;
                   if (fieldLatitude.getText().isEmpty()) {
                    latitude=0;
                    
                   } else {
                    latitude=Double.parseDouble(fieldLatitude.getText());
                    
                   }
                   double longitude;
                   if (fieldLongitude.getText().isEmpty()) {
                    longitude=0;
                    
                   } else {
                    longitude=Double.parseDouble(fieldLongitude.getText());
                   }
                   layerManager.supprimerLayer(new Layer(id, nom, latitude, longitude));
                   updateData();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    System.out.println("erreur de suppression");
                }
            }
            
        });
        buttonRechercher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LayerManager layerManager=new LayerManager();
                    int id;
                   if (fieldId.getText().isEmpty()) {
                    id=0;
                    
                   } else {
                    id=Integer.parseInt(fieldId.getText());
                   }

                   String nom;
                   if (fieldNom.getText().isEmpty()) {
                    nom="";
                   } else {
                    nom=fieldNom.getText();
                    
                   }
                   double latitude;
                   if (fieldLatitude.getText().isEmpty()) {
                    latitude=0;
                    
                   } else {
                    latitude=Double.parseDouble(fieldLatitude.getText());
                    
                   }
                   double longitude;
                   if (fieldLongitude.getText().isEmpty()) {
                    longitude=0;
                    
                   } else {
                    longitude=Double.parseDouble(fieldLongitude.getText());
                   }
                  List<Layer>list= layerManager.rechercherLayer(new Layer(id, nom, latitude, longitude));

                  //affichage de la liste selectioonée
                  JFrame jFrame=new JFrame();
                  jFrame.setTitle("liste des couches selectionnées");
                  jFrame.setSize(500,300);
                  jFrame.setLayout(new BorderLayout());
                  JPanel panel=new JPanel();
                  jFrame.add(panel);
                  DefaultTableModel model=new DefaultTableModel(new Object[]{"id","nom","latitude","longitude"},0);
                  JTable table=new JTable(model);
                  JScrollPane scrollpane=new JScrollPane(table);
                  for(Layer layer:list)
                  {
                     model.addRow(new Object[]{layer.getId(),layer.getNom(),layer.getLatitude(),layer.getLongitude()});

                  }
                  
                  panel.add(scrollpane);
                  jFrame.setVisible(true);

                   
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    System.out.println("erreur de recherche");
                }
                
            }
        });
        buttonChat.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ChatGUI chatGUI=new ChatGUI(username);
            }
            
        });
    }

    public void updateData()
    {
        try {
            LayerManager layerManager=new LayerManager();
            List <Layer> list=layerManager.getLayer();
            model.setRowCount(0);
            for (Layer layer:list) {
                model.addRow(new Object[]{layer.getId(),layer.getNom(),layer.getLatitude(),layer.getLongitude()});
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erreur de mise à jour");
        }
        


    }

}
