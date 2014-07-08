package gui2;

import elements.Edge;
import elements.Force;
import elements.Node;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FileManager {

    private int saveLimit = 1000;
    private int printLimit = 1000;
    private int isolut = 2;

    private double tStart = 0;
    private double tStop = 10;
    private double deltaT = 1;

    private int numberNodes = 0;
    private String nodeFile = "node_file.dat";
    private String elemFile = "elem_file.dat";
    private String inputFile = "input.dat";
    private String confFile = "conf_file.dat";
    private String pressFile = "pres_file.dat";
    private File filePath;
    private File fortranPath;

    private int NELG = 0;
    private int NMAT = 0;
    private double dO = 0.127;
    private double dI = 0.120;

    private double teMod = 0;
    private int tDens = 0;
    private double tPoi = 0;

    private int iterations = 10;

    private int type_I = 2;
    private double tolerance = 0.001;
    private double stiffness = 0.555E+07;
    private double diam = 0.127E-01;
    private boolean displayScreen = true;

    //Turbulence
    private double turbF1 = 0.0;
    private double turbF2 = 60.0;
    private double turbDF = 60.0;
    private int turbModel = 1;
    private double corrLen = 0.25;
    //Turbulence

    //FEI
    private int feiModel = 1;
    private int nFlex = 1;

    //L%W
    private double turbLoss = 0.275;
    private double RLFC = 2.0;
    private boolean varSTDU = false;
    private boolean varSTDA = false;
    private int areaAmpModel = 1;
    private int timeLagModel = 2;
    //L%W

    //P&P
    private double dragCoeff = 0.1;
    private double DCL_DY = 0.1;
    private double pepMU = 1;
    //P&P

    //Connors
    private double conCoeff = 2.4;
    private double conExp = 0.5;
    //Connors

    private double damping = 0.005;
    private int intMethod = 1;
    private double gamma = 0.5;
    private double beta = 0.25;

    private int bType = 1;
    private double p_d = 1.25;

    private Model modelo;

    public FileManager() {

        filePath = new File(new File(".").getAbsolutePath());
        fortranPath = new File(new File(".").getAbsolutePath());
    }

    public void generateXMLFile() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("Model");
            doc.appendChild(rootElement);

            generateInputXMLFile(doc, rootElement);
            generateNodeXMLFile(doc, rootElement);
            generateElemXMLFile(doc, rootElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("file.xml"));

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateNodeXMLFile(Document doc, Element elem) {
        ArrayList<Node> nodes = modelo.getNodes();
        if (nodes.isEmpty()) {
            return;
        }
        double lowerX = nodes.get(0).getPos().x;
        double lowerY = nodes.get(0).getPos().y;

        for (Node n : nodes) {
            if (n.getPos().x < lowerX) {
                lowerX = n.getPos().getX();
            }
            if (n.getPos().y < lowerY) {
                lowerY = n.getPos().getY();
            }
        }

        Element allNodes = doc.createElement("Nodes");
        elem.appendChild(allNodes);

        for (Node n : nodes) {
            Element node = doc.createElement("Node");
            allNodes.appendChild(node);

            Attr attr = doc.createAttribute("id");
            attr.setValue(n.getNumber() + "");
            node.setAttributeNode(attr);

            Element constraint = doc.createElement("Constaint");
            node.appendChild(constraint);

            Element consX = doc.createElement("X");
            consX.appendChild(doc.createTextNode(n.isX().toString()));
            constraint.appendChild(consX);

            Element consY = doc.createElement("Y");
            consY.appendChild(doc.createTextNode(n.isY().toString()));
            constraint.appendChild(consY);

            Element consZ = doc.createElement("Z");
            consZ.appendChild(doc.createTextNode(n.isZ().toString()));
            constraint.appendChild(consZ);

            Element consRX = doc.createElement("RX");
            consRX.appendChild(doc.createTextNode(n.isRx().toString()));
            constraint.appendChild(consRX);

            Element consRY = doc.createElement("RY");
            consRY.appendChild(doc.createTextNode(n.isRy().toString()));
            constraint.appendChild(consRY);

            Element consRZ = doc.createElement("RZ");
            consRZ.appendChild(doc.createTextNode(n.isRz().toString()));
            constraint.appendChild(consRZ);

            Element position = doc.createElement("Position");
            node.appendChild(position);

            Element posX = doc.createElement("X");
            posX.appendChild(doc.createTextNode(n.getPos().x + ""));
            position.appendChild(posX);

            Element posY = doc.createElement("Y");
            posY.appendChild(doc.createTextNode(n.getPos().y + ""));
            position.appendChild(posY);

            Element posZ = doc.createElement("Z");
            posZ.appendChild(doc.createTextNode("0.0"));
            position.appendChild(posZ);

            Element conforces = null;
            if (!n.getForces().isEmpty()) {
                conforces = doc.createElement("Conforces");
                node.appendChild(conforces);
            }

            for (Force f : n.getForces()) {
                Element axis = doc.createElement(f.getAxis());
                axis.appendChild(doc.createTextNode(f.getValue() + ""));
                conforces.appendChild(axis);
            }

        }

    }

    private void generateElemXMLFile(Document doc, Element elem) {

        Element elements = doc.createElement("Elements");
        elem.appendChild(elements);

        ArrayList<Edge> edges = modelo.getEdges();

        for (Edge e : edges) {
            Element element = doc.createElement("Element");
            elements.appendChild(element);

            Attr attr = doc.createAttribute("id");
            attr.setValue(e.getNumber() + "");
            element.setAttributeNode(attr);

            Element nodes = doc.createElement("Nodes");
            element.appendChild(nodes);

            Element node1 = doc.createElement("Node1");
            node1.appendChild(doc.createTextNode(e.getNode1().getNumber() + ""));
            nodes.appendChild(node1);

            Element node2 = doc.createElement("Node2");
            node2.appendChild(doc.createTextNode(e.getNode2().getNumber() + ""));
            nodes.appendChild(node2);

            if (e.getPressureValue() != 0) {
                int i = 0;
                String[] axis = {"X", "Y", "Z"};
                Element pressure = doc.createElement("Pressure");
                element.appendChild(pressure);

                Element value = doc.createElement("Value");
                value.appendChild(doc.createTextNode(e.getPressureValue() + ""));
                element.appendChild(value);

                for (int vec : e.getPressureUnitVector()) {
                    Element unit = doc.createElement(axis[i]);
                    unit.appendChild(doc.createTextNode(vec + ""));
                    pressure.appendChild(unit);
                    i++;
                }
            }
            if (e.getFlowVelocity() != 0) {
                int i = 0;
                String[] axis = {"X", "Y", "Z"};
                Element fluid = doc.createElement("Fluid");
                element.appendChild(fluid);

                Element flow = doc.createElement("Velocity");
                flow.appendChild(doc.createTextNode(e.getFlowVelocity() + ""));
                element.appendChild(flow);

                Element density = doc.createElement("Density");
                density.appendChild(doc.createTextNode(e.getFluidDensity() + ""));
                element.appendChild(density);

                for (int vec : e.getPressureUnitVector()) {
                    Element unit = doc.createElement(axis[i]);
                    unit.appendChild(doc.createTextNode(vec + ""));
                    fluid.appendChild(unit);
                    i++;
                }
            }

        }
    }

    public void generateAllFiles() {
        modelo = Model.getInstance();
        generateInputFile();
        generateElemFile();
        generateNodeFile();
        generateConfFile();
        generatePressureFile();
        generateXMLFile();
    }

    private void generateNodeFile() {
        ArrayList<Node> nodes = modelo.getNodes();
        if (nodes.isEmpty()) {
            return;
        }
        double lowerX = nodes.get(0).getPos().x;
        double lowerY = nodes.get(0).getPos().y;

        for (Node n : nodes) {
            if (n.getPos().x < lowerX) {
                lowerX = n.getPos().getX();
            }
            if (n.getPos().y < lowerY) {
                lowerY = n.getPos().getY();
            }
        }

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(4);

        File nodeFile = new File(this.nodeFile);
        try {
            BufferedWriter nodeOutput = new BufferedWriter(new FileWriter(nodeFile));
            String line;
            for (Node n : nodes) {
                line = n.getNumber() + " "
                        + (n.isX() ? "1" : "0") + " "
                        + (n.isY() ? "1" : "0") + " "
                        + (n.isZ() ? "1" : "0") + " "
                        + (n.isRx() ? "1" : "0") + " "
                        + (n.isRy() ? "1" : "0") + " "
                        + (n.isRz() ? "1" : "0") + " "
                        + df.format(n.getPos().getX() - lowerX) + " "
                        + df.format(n.getPos().getY() - lowerY) + " 0.0\n";
                nodeOutput.write(line);
            }
            nodeOutput.close();
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateConfFile() {
        ArrayList<Node> nodes = modelo.getNodes();
        if (nodes.isEmpty()) {
            return;
        }
        File confFile = new File(this.confFile);
        try {
            BufferedWriter confOutput = new BufferedWriter(new FileWriter(confFile));
            String line;
            for (Node n : nodes) {
                for (Force f : n.getForces()) {
                    line = n.getNumber() + " "
                            + f.getAxisNumber() + " "
                            + f.getValue() + "\n";
                    confOutput.write(line);
                }

            }
            confOutput.close();
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateElemFile() {
        File file = new File(this.elemFile);
        ArrayList<Edge> edges = modelo.getEdges();
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            for (Edge e : edges) {
                String line;
                line = e.getNumber() + " "
                        + e.getNode1().getNumber() + " "
                        + e.getNode2().getNumber() + "\n";
                output.write(line);
            }
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void generatePressureFile() {
        File file = new File(this.pressFile);
        ArrayList<Edge> edges = modelo.getEdges();
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            for (Edge e : edges) {
                String line;
                int i = 1;
                for (int vec : e.getFlowUnitVector()) {
                    if (vec != 0) {
                        line = e.getNumber() + " "
                                + i + " " + vec + "\n";
                        output.write(line);
                    }
                    i++;
                }
            }
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateInputXMLFile(Document doc, Element elem) {

        //<editor-fold defaultstate="collapsed" desc="Solution">
        Element top = doc.createElement("Solution");
        elem.appendChild(top);

        Element temp = doc.createElement("Isolut");
        temp.appendChild(doc.createTextNode(isolut + ""));
        top.appendChild(temp);

        temp = doc.createElement("Save_Limit");
        temp.appendChild(doc.createTextNode(saveLimit + ""));
        top.appendChild(temp);

        temp = doc.createElement("If_Turbulence");
        temp.appendChild(doc.createTextNode(modelo.isTurbulence().toString()));
        top.appendChild(temp);

        temp = doc.createElement("If_Fluid");
        temp.appendChild(doc.createTextNode(modelo.isFluidFlow().toString()));
        top.appendChild(temp);

        temp = doc.createElement("If_FEI");
        temp.appendChild(doc.createTextNode(modelo.isFei().toString()));
        top.appendChild(temp);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Dynamics">
        top = doc.createElement("Dynamics");
        elem.appendChild(top);

        temp = doc.createElement("IDynamics");
        temp.appendChild(doc.createTextNode("1"));
        top.appendChild(temp);

        temp = doc.createElement("Damping");
        temp.appendChild(doc.createTextNode(damping + ""));
        top.appendChild(temp);

        temp = doc.createElement("Method");
        temp.appendChild(doc.createTextNode(intMethod + ""));
        top.appendChild(temp);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Timing">
        top = doc.createElement("Timing");
        elem.appendChild(top);

        temp = doc.createElement("Start");
        temp.appendChild(doc.createTextNode(tStart + ""));
        top.appendChild(temp);

        temp = doc.createElement("Stop");
        temp.appendChild(doc.createTextNode(tStop + ""));
        top.appendChild(temp);

        temp = doc.createElement("Delta_T");
        temp.appendChild(doc.createTextNode(deltaT + ""));
        top.appendChild(temp);

        temp = doc.createElement("Delta_T");
        temp.appendChild(doc.createTextNode(deltaT + ""));
        top.appendChild(temp);

        temp = doc.createElement("Gamma");
        temp.appendChild(doc.createTextNode(gamma + ""));
        top.appendChild(temp);

        temp = doc.createElement("Beta");
        temp.appendChild(doc.createTextNode(beta + ""));
        top.appendChild(temp);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Node List">
        top = doc.createElement("Node_List");
        elem.appendChild(top);

        temp = doc.createElement("NNP");
        temp.appendChild(doc.createTextNode(modelo.getNodes().size() + ""));
        top.appendChild(temp);

        temp = doc.createElement("NELG");
        temp.appendChild(doc.createTextNode(NELG + ""));
        top.appendChild(temp);

        temp = doc.createElement("NMAT");
        temp.appendChild(doc.createTextNode(NMAT + ""));
        top.appendChild(temp);

        temp = doc.createElement("D_I");
        temp.appendChild(doc.createTextNode(dI + ""));
        top.appendChild(temp);

        temp = doc.createElement("D_O");
        temp.appendChild(doc.createTextNode(dO + ""));
        top.appendChild(temp);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Material">
        top = doc.createElement("Material");
        elem.appendChild(top);

        temp = doc.createElement("TEMOD");
        temp.appendChild(doc.createTextNode(teMod + ""));
        top.appendChild(temp);

        temp = doc.createElement("TDENS");
        temp.appendChild(doc.createTextNode(tDens + ""));
        top.appendChild(temp);

        temp = doc.createElement("TPOI");
        temp.appendChild(doc.createTextNode(tPoi + ""));
        top.appendChild(temp);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Tube Bundle">
        top = doc.createElement("Tube_Bundle");
        elem.appendChild(top);

        temp = doc.createElement("B_Type");
        temp.appendChild(doc.createTextNode(bType + ""));
        top.appendChild(temp);

        temp = doc.createElement("P_D");
        temp.appendChild(doc.createTextNode(p_d + ""));
        top.appendChild(temp);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Turbulence">
        top = doc.createElement("Turbulence");
        elem.appendChild(top);

        temp = doc.createElement("F1");
        temp.appendChild(doc.createTextNode(turbF1 + ""));
        top.appendChild(temp);

        temp = doc.createElement("F2");
        temp.appendChild(doc.createTextNode(turbF2 + ""));
        top.appendChild(temp);

        temp = doc.createElement("DF");
        temp.appendChild(doc.createTextNode(turbDF + ""));
        top.appendChild(temp);

        temp = doc.createElement("Model");
        temp.appendChild(doc.createTextNode(turbModel + ""));
        top.appendChild(temp);

        temp = doc.createElement("Correlation_Length");
        temp.appendChild(doc.createTextNode(corrLen + ""));
        top.appendChild(temp);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Fluidelastic">
        top = doc.createElement("Fluidelastic");
        elem.appendChild(top);

        temp = doc.createElement("Model");
        temp.appendChild(doc.createTextNode(feiModel + ""));
        top.appendChild(temp);

        temp = doc.createElement("NFlex");
        temp.appendChild(doc.createTextNode(nFlex + ""));
        top.appendChild(temp);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Impact">
        top = doc.createElement("Impact");
        elem.appendChild(top);

        temp = doc.createElement("Iterations");
        temp.appendChild(doc.createTextNode(iterations + ""));
        top.appendChild(temp);

        temp = doc.createElement("Beta");
        temp.appendChild(doc.createTextNode(beta + ""));
        top.appendChild(temp);

        temp = doc.createElement("Type_I");
        temp.appendChild(doc.createTextNode(type_I + ""));
        top.appendChild(temp);

        temp = doc.createElement("Tolerance");
        temp.appendChild(doc.createTextNode(tolerance + ""));
        top.appendChild(temp);

        temp = doc.createElement("Stiffness");
        temp.appendChild(doc.createTextNode(stiffness + ""));
        top.appendChild(temp);

        temp = doc.createElement("Diameter");
        temp.appendChild(doc.createTextNode(diam + ""));
        top.appendChild(temp);

        temp = doc.createElement("DisplayScreen");
        temp.appendChild(doc.createTextNode(displayScreen + ""));
        top.appendChild(temp);
        //</editor-fold>

    }

    private void generateInputFile() {
        File file = new File(this.inputFile);
        ArrayList<Edge> edges = modelo.getEdges();
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            String line;

            output.write("&SOLUTION\n");
            line = "ISOLUT=" + isolut
                    + ", SAVE_LIMIT=" + saveLimit
                    + ", PRINT_LIMIT=" + printLimit
                    + ", IFTURB=" + (modelo.isTurbulence() ? "1" : "0")
                    + ", IFLUID_FLOW=" + (modelo.isFluidFlow() ? "1" : "0")
                    + ", IFFEI=" + (modelo.isFei() ? "1" : "0")
                    + "\n/\n";
            output.write(line);

            output.write("&DYNAMICS\n");
            line = "IDYNM=1"
                    + ", DAMPING=" + damping
                    + ", INTMETHOD=" + intMethod
                    + "\n/\n";
            output.write(line);

            output.write("&TIMING\n");
            line = "TSTART=" + tStart
                    + ", TSTOP=" + tStop
                    + ", DELTAT=" + deltaT
                    + ", gamma=" + gamma
                    + ", beta_int=" + beta
                    + "\n/\n";
            output.write(line);

            output.write("&NODELIST\n");
            line = "NNP=" + modelo.getNodes().size()
                    + ", nodefile='" + nodeFile + "',"
                    + "NELG=" + NELG
                    + ", NMAT=" + NMAT
                    + ", elemfile='" + elemFile + "'"
                    + ", conffile='" + confFile + "'"
                    + ", d_o=" + dO
                    + ", d_i=" + dI
                    + "\n/\n";
            output.write(line);

            output.write("&CONFORCES\n");
            line = "NCONF=1" //CHECK!!!!!!!!!!!!!!!
                    + ", conffile='" + confFile + "'"
                    + "\n/\n";
            output.write(line);

            output.write("&PRESSURE\n");
            line = "IPRES=1" //CHECK!!!!!!!!!!!!!!!
                    + ", presfile='" + pressFile + "'"
                    + "\n/\n";
            output.write(line);

            output.write("&MATERIAL01\n");
            line = "TEMOD=" + teMod
                    + ", TDENS=" + tDens
                    + ", TPOI=" + tPoi + "\n/\n";
            output.write(line);

            output.write("&TUBE_BUNDLE\n");
            line = "B_TYPE=" + bType
                    + ", P_D=" + p_d
                    + "\n/\n";
            output.write(line);

            int i = 0;
            for (Edge e : edges) {
                if (e.getFlowVelocity() != 0) {
                    line = "fluid(" + i + ",1:6)="
                            + e.getNumber() + ","
                            + e.getFlowVelocity() + ","
                            + e.getFluidDensity() + ","
                            + e.getFlowUnitVector()[0] + ","
                            + e.getFlowUnitVector()[1] + ","
                            + e.getFlowUnitVector()[2] + "\n";
                    output.write(line);
                    i++;
                }
            }
            output.write("\n/\n");

            output.write("&TURBULENCE\n");
            line = "TURB_F1=" + turbF1
                    + ", TURB_F2=" + turbF2
                    + ", TURB_dF=" + turbDF
                    + ", TURB_MODEL=" + turbModel
                    + ", CORR_LEN=" + corrLen
                    + "\n/\n";
            output.write(line);

            output.write("&FLUIDELASTIC\n");
            line = "FEI_MODEL=" + feiModel
                    + ", NFLEX=" + nFlex
                    + "\n/\n";
            output.write(line);

            output.write("&IMPACT\n");
            line = "ITERATIONS=" + iterations + "\n"
                    + "BETA=" + beta + "\n"
                    + "TYPE_I=" + type_I + "\n"
                    + "TOLERANCE=" + tolerance + "\n"
                    + "STIFF=" + stiffness + "\n"
                    + "DIAM=" + diam + "\n"
                    + "DISPTOSCREEN=." + (displayScreen ? "TRUE" : "FALSE") + ".\n"
                    + "NODE=";
            output.write(line);

            line = "";
            for (Edge e : edges) {
                line += e.getNumber() + " ";
            }
            line += "\n/";
            output.write(line);

            output.close();
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double gettStart() {
        return tStart;
    }

    public void settStart(double tStart) {
        this.tStart = tStart;
    }

    public double gettStop() {
        return tStop;
    }

    public void settStop(double tStop) {
        this.tStop = tStop;
    }

    public double getDeltaT() {
        return deltaT;
    }

    public void setDeltaT(double deltaT) {
        this.deltaT = deltaT;
    }

    public int getNumberNodes() {
        return numberNodes;
    }

    public void setNumberNodes(int numberNodes) {
        this.numberNodes = numberNodes;
    }

    public String getNodeFile() {
        return nodeFile;
    }

    public void setNodeFile(String nodeFile) {
        this.nodeFile = nodeFile;
    }

    public String getElemFile() {
        return elemFile;
    }

    public void setElemFile(String elemFile) {
        this.elemFile = elemFile;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getConfFile() {
        return confFile;
    }

    public void setConfFile(String confFile) {
        this.confFile = confFile;
    }

    public int getNELG() {
        return NELG;
    }

    public void setNELG(int NELG) {
        this.NELG = NELG;
    }

    public int getNMAT() {
        return NMAT;
    }

    public void setNMAT(int NMAT) {
        this.NMAT = NMAT;
    }

    public double getdO() {
        return dO;
    }

    public void setdO(double dO) {
        this.dO = dO;
    }

    public double getdI() {
        return dI;
    }

    public void setdI(double dI) {
        this.dI = dI;
    }

    public double getTeMod() {
        return teMod;
    }

    public void setTeMod(double teMod) {
        this.teMod = teMod;
    }

    public int gettDens() {
        return tDens;
    }

    public void settDens(int tDens) {
        this.tDens = tDens;
    }

    public double gettPoi() {
        return tPoi;
    }

    public void settPoi(double tPoi) {
        this.tPoi = tPoi;
    }

    public int getnFlex() {
        return nFlex;
    }

    public void setnFlex(int nFlex) {
        this.nFlex = nFlex;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public int getType_I() {
        return type_I;
    }

    public void setType_I(int type_I) {
        this.type_I = type_I;
    }

    public double getTolerance() {
        return tolerance;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public double getStiffness() {
        return stiffness;
    }

    public void setStiffness(double stiffness) {
        this.stiffness = stiffness;
    }

    public double getDiam() {
        return diam;
    }

    public void setDiam(double diam) {
        this.diam = diam;
    }

    public boolean isDisplayScreen() {
        return displayScreen;
    }

    public void setDisplayScreen(boolean displayScreen) {
        this.displayScreen = displayScreen;
    }

    public File getFilePath() {
        return filePath;
    }

    public void setFilePath(File filePath) {
        this.filePath = filePath;
    }

    public File getFortranPath() {
        return fortranPath;
    }

    public void setFortranPath(File fortranPath) {
        this.fortranPath = fortranPath;
    }

    public int getSaveLimit() {
        return saveLimit;
    }

    public void setSaveLimit(int saveLimit) {
        this.saveLimit = saveLimit;
    }

    public int getPrintLimit() {
        return printLimit;
    }

    public void setPrintLimit(int printLimit) {
        this.printLimit = printLimit;
    }

    public double getTurbF1() {
        return turbF1;
    }

    public void setTurbF1(double turbF1) {
        this.turbF1 = turbF1;
    }

    public double getTurbF2() {
        return turbF2;
    }

    public void setTurbF2(double turbF2) {
        this.turbF2 = turbF2;
    }

    public double getTurbDF() {
        return turbDF;
    }

    public void setTurbDF(double turbDF) {
        this.turbDF = turbDF;
    }

    public int getTurbModel() {
        return turbModel;
    }

    public void setTurbModel(int turbModel) {
        this.turbModel = turbModel;
    }

    public double getCorrLen() {
        return corrLen;
    }

    public void setCorrLen(double corrLen) {
        this.corrLen = corrLen;
    }

    public int getFeiModel() {
        return feiModel;
    }

    public void setFeiModel(int feiModel) {
        this.feiModel = feiModel;
    }

    public double getTurbLoss() {
        return turbLoss;
    }

    public void setTurbLoss(double turbLoss) {
        this.turbLoss = turbLoss;
    }

    public double getRLFC() {
        return RLFC;
    }

    public void setRLFC(double RLFC) {
        this.RLFC = RLFC;
    }

    public boolean isVarSTDU() {
        return varSTDU;
    }

    public void setVarSTDU(boolean varSTDU) {
        this.varSTDU = varSTDU;
    }

    public boolean isVarSTDA() {
        return varSTDA;
    }

    public void setVarSTDA(boolean varSTDa) {
        this.varSTDA = varSTDa;
    }

    public int getAreaAmpModel() {
        return areaAmpModel;
    }

    public void setAreaAmpModel(int areaAmpModel) {
        this.areaAmpModel = areaAmpModel;
    }

    public int getTimeLagModel() {
        return timeLagModel;
    }

    public void setTimeLagModel(int timeLagModel) {
        this.timeLagModel = timeLagModel;
    }

    public double getDragCoeff() {
        return dragCoeff;
    }

    public void setDragCoeff(double dragCoeff) {
        this.dragCoeff = dragCoeff;
    }

    public double getDCL_DY() {
        return DCL_DY;
    }

    public void setDCL_DY(double DCL_DY) {
        this.DCL_DY = DCL_DY;
    }

    public double getPepMU() {
        return pepMU;
    }

    public void setPepMU(double pepMU) {
        this.pepMU = pepMU;
    }

    public double getConCoeff() {
        return conCoeff;
    }

    public void setConCoeff(double conCoeff) {
        this.conCoeff = conCoeff;
    }

    public double getConExp() {
        return conExp;
    }

    public void setConExp(double conExp) {
        this.conExp = conExp;
    }

    public int getIsolut() {
        return isolut;
    }

    public void setIsolut(int isolut) {
        this.isolut = isolut;
    }

    public double getDamping() {
        return damping;
    }

    public void setDamping(double damping) {
        this.damping = damping;
    }

    public int getIntMethod() {
        return intMethod;
    }

    public void setIntMethod(int intMethod) {
        this.intMethod = intMethod;
    }

    public double getGamma() {
        return gamma;
    }

    public void setGamma(double gamma) {
        this.gamma = gamma;
    }

    public int getbType() {
        return bType;
    }

    public void setbType(int bType) {
        this.bType = bType;
    }

    public double getP_d() {
        return p_d;
    }

    public void setP_d(double p_d) {
        this.p_d = p_d;
    }

}
