package Xpath;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Xpath
 * Nombre_project: AccesBase
 * Ex18_Sheng_Ye
 * Created by: sheng
 * Date : 02/12/2021
 * Description:
 **/
public class Ex18_Sheng_Ye {

    public static void main(String[] args) throws FileNotFoundException, XPathExpressionException {
        Ex18_Sheng_Ye ex18_sheng_ye = new Ex18_Sheng_Ye();
        ex18_sheng_ye.menu2();
    }
    //Metodo para hacer las consultas con xpath , en donde le pasamos el string y depende de que expresion
    //de xpath que le pasamos nos hara la consulta de una cosa o otra
    public void consultasXpath(String xPathExpression) throws FileNotFoundException, XPathExpressionException {
        //Hacemos el input en donde leera el archivo
        InputSource inputSource = new InputSource(new FileInputStream("src/xml/trabajadores.xml"));
        //Hacemos el xpathfactory en donde crea una nueva instancia
        XPathFactory factory = XPathFactory.newInstance();
        //y creamos el xpath
        XPath xPath = factory.newXPath();
        //Y la expresion que le psaremos cuando escriba o cuando pregunte
        XPathExpression expression = xPath.compile(xPathExpression);
        //Un nodo en que pasara el xml
        NodeList nodos = (NodeList) expression.evaluate(inputSource, XPathConstants.NODESET);

        for (int i=0;i<nodos.getLength();i++){
                System.out.println(nodos.item(i).getNodeName() + " : " +
                        nodos.item(i).getTextContent());
        }
    }


    public void menu2() throws FileNotFoundException, XPathExpressionException {
        boolean bandera = true;
        while (bandera) {
            System.out.println("********************************************************");
            System.out.println("Elige opcion: ");
            System.out.println("1.-Sacar el nombre a partir del ID");
            System.out.println("2.-Sacar el listado de trabajadores de 30 años");
            System.out.println("3.-Sacar el listado de las trabajadoras que hay en la empresa.");
            System.out.println("4.-Sacar el listado de los trabajadores que tienen como rol  “Java Developer”.");
            System.out.println("salir");
            System.out.println("*********************************************************");


            Scanner scanner = new Scanner(System.in);

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("Escribe un ID: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String texto = scanner1.nextLine();
                    //Aqui hacemos las consultas en que le pasamos la expresion segun lo que quiere saber
                    consultasXpath("//Trabajador[@id="+texto+"]//nombre");
                    break;
                case "2":
                    //Aqui hacemos las consultas en que le pasamos la expresion segun lo que quiere saber

                    consultasXpath("//Trabajador[edad>30]//nombre");
                    break;
                case "3":
                    //Aqui hacemos las consultas en que le pasamos la expresion segun lo que quiere saber
                    consultasXpath("//Trabajador[genero='Mujer']//nombre");
                    break;
                case "4":
                    //Aqui hacemos las consultas en que le pasamos la expresion segun lo que quiere saber
                    consultasXpath("//Trabajador[rol='Java Developer']//nombre");
                    break;
                case "salir":
                    bandera = false;
                    break;
            }
        }
    }



}
