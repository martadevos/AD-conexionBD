import java.sql.*;

public class Conexion {
    private static String servidor = "jdbc:mysql://dns11036.phdns11.es";
    private static Connection connection_;
    private static java.sql.Statement con = null;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection_ = DriverManager.getConnection(servidor, "ad2223", "nervion");
            if (connection_ != null) {
                con = connection_.createStatement();
                System.out.println("Conexion a base de datos test correcta . ");
                System.out.println(con.toString());
                String[] campos = {"ID int PRIMARY KEY AUTO_INCREMENT", "nombre varchar(255)", "apellidos varchar(255)", "edad int"};
                String[] campos2 = {"laboral varchar(255)"};
                String[] valores = {
                        "('Ulberto', 'Jobin', 16), ", "('Fallon', 'Frenzl', 63), ", "('Ken', 'Legan', 86), ",
                        "('Lorain', 'Jakeman', 68), ", "('Moe', 'Santhouse', 56), ", "('Sig', 'Sciusscietto', 16), ",
                        "('Gerhardt', 'Seakings', 65), ", "('Lorrie', 'Lenthall', 61), ", "('Westleigh', 'Zorener', 77), ",
                        "('Stefania', 'Cleyburn', 56), ", "('Hogan', 'Spere', 96), ", "('Ario', 'De Witt', 20), ",
                        "('Viviene', 'Kilcullen', 47), ", "('Cecil', 'Allard', 39), ", "('Crissie', 'Skirrow', 14), ",
                        "('Gerda', 'Kelcher', 66), ", "('Sidoney', 'Waycot', 39), ", "('Minni', 'Goozee', 90), ",
                        "('Dani', 'Sarre', 48), ", "('Kingston', 'Stephens', 40), ", "('Rici', 'Mokes', 75), ",
                        "('Giacomo', 'Field', 98), ", "('Nollie', 'Hein', 56), ", "('Iormina', 'Crutch', 16), ",
                        "('Shalne', 'Menendes', 30), ", "('Gearard', 'Troucher', 65), ", "('Orazio', 'Camus', 54), ",
                        "('Gradey', 'Garatty', 58), ", "('Mitchell', 'Devenport', 79), ", "('Myrle', 'Garralts', 48), ",
                        "('Jacobo', 'Duchan', 43), ", "('Pearla', 'Hanson', 48), ", "('Kane', 'Paige', 31), ",
                        "('Jacquenette', 'Iddons', 18), ", "('Elwin', 'Elies', 29), ", "('Hendrick', 'Birden', 26), ",
                        "('Brandie', 'Nosworthy', 18), ", "('Shaylyn', 'Mirando', 73), ", "('Kimball', 'Marjanski', 93), ",
                        "('Hugh', 'Hickisson', 71), ", "('Devan', 'Downton', 21), ", "('Lilith', 'Cooke', 74), ",
                        "('Arabella', 'Vasilenko', 99), ", "('Halsy', 'Tiltman', 58), ", "('Gianina', 'Yorath', 95), ",
                        "('Ban', 'Skeffington', 40), ", "('Daryle', 'Filchagin', 25), ", "('Nixie', 'Heining', 36), ",
                        "('Sherlock', 'Wace', 61), ", "('Carlynn', 'Dancy', 97), ", "('Bride', 'Derry', 15), ",
                        "('Nathanil', 'Wace', 38), ", "('Hillier', 'Congreave', 98), ", "('Marje', 'Speak', 35), ",
                        "('Amble', 'Spradbery', 64), ", "('Shir', 'Deerr', 24), ", "('Elbertine', 'Gettins', 42), ",
                        "('Justen', 'Stannus', 71), ", "('Mandie', 'McComish', 90), ", "('Elisha', 'Hartfield', 30), ",
                        "('Fabian', 'Leadbetter', 22), ", "('Bertram', 'Dullaghan', 37), ", "('Leena', 'Nockles', 54), ",
                        "('Cris', 'Joysey', 41), ", "('Lilia', 'Denes', 97), ", "('Camella', 'Farryan', 55), ", "('Tammie', 'Durdy', 39), ",
                        "('Peggy', 'Pressland', 93), ", "('Vick', 'MacLaughlin', 85), ", "('Clarine', 'Denver', 46), ",
                        "('Karylin', 'Bettinson', 51), ", "('Mala', 'Burchett', 31), ", "('Leese', 'Seif', 41), ",
                        "('Krystle', 'Marfield', 47), ", "('Basil', 'Glowacha', 74), ", "('Gard', 'Gilbart', 58), ",
                        "('Francesca', 'Dodson', 72), ", "('Sydney', 'Aspinall', 81), ", "('Jeanie', 'Whitrod', 71), ",
                        "('Sayers', 'Keys', 69), ", "('Sabrina', 'Woolbrook', 55), ", "('Cosmo', 'Filppetti', 31), ",
                        "('Karie', 'Cantero', 25), ", "('Karol', 'Bruford', 43), ", "('Ilsa', 'Cromleholme', 87), ",
                        "('Lavinia', 'Weiser', 30), ", "('Lombard', 'Van Weedenburg', 74), ", "('Gloriane', 'Curthoys', 98), ",
                        "('Granny', 'Dominka', 75), ", "('Sharlene', 'MacInherney', 90), ", "('Doretta', 'Benza', 28), ",
                        "('Dael', 'Johnstone', 34), ", "('Ashlen', 'Mellmer', 68), ", "('Edmund', 'Metzing', 50), ",
                        "('Griselda', 'Mashal', 46), ", "('Harris', 'Kelson', 38), ", "('Berti', 'Gres', 37), ",
                        "('Carol-jean', 'Jodlkowski', 42), ", "('Darrell', 'Belfitt', 37), ", "('Belle', 'Rubinsohn', 85), ",
                        "('Zeke', 'Spehr', 26), ", "('Claiborne', 'Cashley', 65), ", "('Ebba', 'Kasparski', 31), ",
                        "('Arluene', 'Desquesnes', 100), ", "('Thaine', 'Niessen', 34), ", "('Nisse', 'Bysh', 60), ",
                        "('Fernando', 'Squibe', 35), ", "('Margalit', 'Reddihough', 48), ", "('Jesus', 'Penhaligon', 38), ",
                        "('Pietra', 'Rossi', 20), ", "('Grant', 'Stiven', 69), ", "('Rivkah', 'Tilney', 85), ",
                        "('Thaddeus', 'Rambadt', 49), ", "('Marni', 'Duxbury', 70), ", "('Matthieu', 'Drynan', 36), ",
                        "('Ashley', 'Rafe', 25), ", "('Myrtice', 'Guiver', 13), ", "('Merilee', 'Vinnicombe', 72), ",
                        "('Burnard', 'Jiranek', 23), ", "('Gare', 'Vinau', 51), ", "('Wake', 'Hubble', 99), ",
                        "('Jillane', 'Breckenridge', 36), ", "('Falkner', 'Peinton', 12), ", "('Jacquetta', 'Ziems', 22), ",
                        "('Tamra', 'Hancox', 36), ", "('Roselia', 'Boam', 29), ", "('Matthus', 'Roxbee', 45), ",
                        "('Corie', 'Pischof', 88), ", "('Laurice', 'Lockney', 50), ", "('Judith', 'Lerigo', 57), ",
                        "('Marchelle', 'Tesyro', 69), ", "('Cyrillus', 'MacQuarrie', 19), ", "('Eugenie', 'Spikeings', 66), ",
                        "('Sisile', 'Marton', 83), ", "('Ardath', 'Pittson', 33), ", "('Celinda', 'Tytterton', 77), ",
                        "('Roxie', 'Pooley', 21), ", "('Domenic', 'Conechie', 44), ", "('Constanta', 'Jentzsch', 65), ",
                        "('Deonne', 'Wickersley', 19), ", "('Rustie', 'Van Halle', 60), ", "('Red', 'Lacroux', 44), ",
                        "('Vida', 'Crennan', 39), ", "('Brander', 'Hehl', 23), ", "('Alfons', 'Sowersby', 90), ",
                        "('Griffith', 'Heugh', 28), ", "('Cloris', 'Colliard', 32), ", "('Rasia', 'Pittway', 45), ",
                        "('Shirley', 'Bale', 20), ", "('Claudian', 'Fenck', 94), ", "('Sean', 'Simone', 87), ",
                        "('Giulia', 'Skyner', 57), ", "('Karrie', 'Stanbra', 98), ", "('Matteo', 'Ickovits', 42), ",
                        "('Merna', 'Levesque', 99), ", "('Witty', 'Glassopp', 95), ", "('Elenore', 'Saunt', 63), ",
                        "('Sheilah', 'Seydlitz', 100), ", "('Ilyse', 'Hubert', 21), ", "('Chilton', 'Goadby', 23), ",
                        "('Karyn', 'Issatt', 15), ", "('Bennett', 'Widdicombe', 12), ", "('Dean', 'Mogie', 18), ",
                        "('Dominique', 'Vero', 45), ", "('Pernell', 'Lashmore', 88), ", "('Donn', 'Laxen', 37), ",
                        "('Raychel', 'Pech', 66), ", "('Tedi', 'MacCarroll', 50), ", "('Julee', 'Piatto', 33), ",
                        "('Remy', 'Barby', 37), ", "('Dannie', 'Passler', 15), ", "('Lotty', 'Farloe', 33), ",
                        "('Eddi', 'MacAne', 62), ", "('Marcelline', 'Farden', 90), ", "('Nelson', 'Sterzaker', 20), ",
                        "('Sibilla', 'MacLleese', 99), ", "('Kin', 'Woolliams', 49), ", "('Katerina', 'Bonsul', 59), ",
                        "('Willow', 'McKeighan', 39), ", "('Mollie', 'Dible', 51), ", "('Byron', 'Geater', 49), ",
                        "('Vasilis', 'Eddleston', 14), ", "('Lawry', 'Porrett', 17), ", "('Rae', 'Brassill', 56), ",
                        "('Desirae', 'Sacco', 48), ", "('Kirby', 'Winsome', 57), ", "('Noelyn', 'Drinkall', 66), ",
                        "('Bryan', 'Bottoner', 27), ", "('Jaymie', 'Godlee', 61), ", "('Andonis', 'Braunlein', 58), ",
                        "('Feodor', 'O Hannen', 47), ", "('Dora', 'Hemerijk', 18), ", "('Caren', 'Lodo', 19), ",
                        "('Lula', 'Benn', 57), ", "('Carroll', 'Tregea', 14), ", "('Lois', 'Wiffill', 21), ",
                        "('Cloris', 'Gosker', 52), ", "('Whittaker', 'Munden', 74), ", "('Angel', 'Stannett', 13), ",
                        "('Loren', 'Mingardi', 65);"};
                //crearTabla(con, "mdevos", campos);
                //introducirDatosTabla(con, "mdevos", valores);
                //Consulta.consultarOrdenEdad(con, "mdevos");
                //Consulta.consultarOrdenApellidos(con, "mdevos");
                //Consulta.consultarMas30Anios(con, "mdevos");
                //Consulta.consultarNombrePorJ(con, "mdevos");
                //Consulta.consultarNombrePorC_ApellidoPorA_OrdenEdadDesc(con, "mdevos");
                //Consulta.consultarMediaEdad(con, "mdevos");
                //Consulta.consultarApellidosConOhAh(con, "mdevos");
                //Consulta.consultarEntre24Y32Anios(con, "mdevos");
                //Consulta.consultarMas65Anios(con, "mdevos");
                //añadirColumnas(con, "mdevos", campos2);
                Actualizacion.actualizarLaboral(con, "mdevos");

            } else {
                System.out.println("Conexión fallida");
            }

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void crearTabla(Statement con, String tabla, String[] campos) {
        String sql = "CREATE TABLE ad2223." + tabla + "(";

        for (int i = 0; i < campos.length - 1; i++) {
            sql += campos[i];
            if (i < campos.length - 1) sql += ", ";
        }
        sql += campos[campos.length - 1] + "";
        System.out.println(sql);

        try {
            con.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void añadirColumnas(Statement con, String tabla, String[] campos) {
        String sql = "ALTER TABLE ad2223." + tabla+" ADD";

        for (int i = 0; i < campos.length - 1 || campos.length > 1; i++) {
            sql += " "+campos[i];
            if (i < campos.length - 1) sql += ", ";
            else sql += ";";
        }
        if (campos.length==1) sql += " "+campos[0]+ ";";
        System.out.println(sql);

        try {
            con.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void introducirDatosTabla(Statement con, String tabla, String[] valores) {
        String sql = "insert into ad2223." + tabla + " (nombre, apellidos, edad) values";

        for (String valor : valores) {
            sql += valor;
        }

        try {
            con.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public static void mostrarDatos(ResultSet lista) {
        ;
        try {
            ResultSetMetaData md = lista.getMetaData();
            while (lista.next()) {
                String cadena = "";
                for (int i = 1; i<=md.getColumnCount(); i++){
                    cadena+= md.getColumnLabel(i).toUpperCase()+": "+lista.getString(md.getColumnLabel(i))+"    ";
                }
                System.out.println(cadena);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}