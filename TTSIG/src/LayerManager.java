import java.sql.*;
import java.util.*;





public class LayerManager {
    private   Connection connection;
    public LayerManager() throws SQLException
    {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://127.0.0.1/layerdb";
            String user="root";
            String password="";
            connection=DriverManager.getConnection(url,user,password);
            System.out.println("connexion reussi");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("connexion echoué");
        }
    }

     public List<Layer> getLayer()
     {
        List<Layer> list=new ArrayList<>();
        try {

            String sql="select * from layer";
            PreparedStatement statement=connection.prepareStatement(sql); 
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()) {

                int id=resultSet.getInt("id");
                String nom=resultSet.getString("nom");
                double latitude=resultSet.getDouble("latitude");
                double longitude=resultSet.getDouble("longitude");
                Layer layer=new Layer(id,nom,latitude,longitude);
                list.add(layer);
                
            }
            
        } catch (SQLException e) {
            System.out.println("erreur d'execution");
        }
        return list;
     }

     public void ajouterLayer(Layer layer)
     {
        
        try {
            String sql="insert into layer values(?,?,?,?)";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,layer.getId());
            statement.setString(2, layer.getNom());
            statement.setDouble(3,layer.getLatitude());
            statement.setDouble(4, layer.getLongitude());
            statement.executeUpdate();
            System.out.println("ajouté avec succes");
            
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("erreur d'execution");
        }
     }
     public List<Layer> rechercherLayer(Layer layer)
     {
       List <Layer> list=new ArrayList<>();
       try {
        String sql="select * from layer where 1=1 ";
        if (layer.getId()!=0) {
            sql+="and id=?";
            
        }
        if (!layer.getNom().isEmpty()) {
            sql+=" and nom=?";
            
        }
        if (layer.getLatitude()!=0) {
            sql+=" and latitude=?";
            
        }
        if (layer.getLongitude()!=0) {
            sql+=" and longitude=?";
            
        }

        PreparedStatement statement=connection.prepareStatement(sql);
        int index=1;
        if (layer.getId()!=0) {
            statement.setInt(index++, layer.getId());
            
        }
        if (!layer.getNom().isEmpty()) {
            statement.setString(index++, layer.getNom());
            
        }
        if (layer.getLatitude()!=0) {
            statement.setDouble(index++, layer.getLatitude());
            
        }
        if (layer.getLongitude()!=0) {
            statement.setDouble(index++, layer.getLongitude());
            
        }



        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()) {
            list.add(new Layer(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getDouble("latitude"), resultSet.getDouble("longitude")));
            
        }





       } catch (SQLException e) {
        System.out.println("erreur d'execution");
       }



       return list;

     }

     public void supprimerLayer(Layer layer)

     {
        try {
            String sql="delete from layer where 1=1 ";
            if (layer.getId()!=0) {
                sql+="and id=?";
                
            }
            if (!layer.getNom().isEmpty()) {
                sql+=" and nom=?";
                
            }
            if (layer.getLatitude()!=0) {
                sql+=" and latitude=?";
                
            }
            if (layer.getLongitude()!=0) {
                sql+=" and longitude=?";
                
            }
    
            PreparedStatement statement=connection.prepareStatement(sql);
            int index=1;
            if (layer.getId()!=0) {
                statement.setInt(index++, layer.getId());
                
            }
            if (!layer.getNom().isEmpty()) {
                statement.setString(index++, layer.getNom());
                
            }
            if (layer.getLatitude()!=0) {
                statement.setDouble(index++, layer.getLatitude());
                
            }
            if (layer.getLongitude()!=0) {
                statement.setDouble(index++, layer.getLongitude());
                
            }
    
    
    
            statement.executeUpdate();
            
    
    
    
    
    
           } catch (SQLException e) {
            System.out.println("erreur d'execution");
           }
    



     }
     public void modifierLayer(Layer layer)
     {
        try {
            String sql="update layer set nom=? ,latitude=?,longitude=? where id=?";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1, layer.getNom());
            statement.setDouble(2, layer.getLatitude());
            statement.setDouble(3, layer.getLongitude());
            statement.setInt(4, layer.getId());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("erreur d'execution");
        }

     }


    

}
