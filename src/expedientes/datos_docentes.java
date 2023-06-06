package expedientes;


public class datos_docentes {
    
    private int id_docente;
    private int id_empleado;
    private String licenciatura;
    private String especialidad;
    private String maestria; 
    private String doctorado;
    private String ed_tituloLic;
    private String ed_cedulaLic;
    private String ed_tituloEsp;
    private String ed_cedulaEsp;
    private String ed_tituloMtria;
    private String ed_cedulaMtria;
    private String ed_tituloDoc;
    private String ed_cedulaDoc;
    private String ed_disa;
    private String ed_profordems;
    private String ed_certidems;

    public void setDatosDocentes (String _id_docente, String _id_empleado, String _licenciatura,
    String _especialidad, String _maestria, String _doctorado, String _ed_tituloLic,
    String _ed_cedulaLic, String _ed_tituloEsp, String _ed_cedulaEsp, String _ed_tituloMtria,
    String _ed_cedulaMtria, String _ed_tituloDoc, String _ed_cedulaDoc, String _ed_disa,
    String _ed_profordems, String _ed_certidems){
        
        setId_docente(Integer.parseInt(_id_docente));
        setId_empleado (Integer.parseInt(_id_empleado));
        setLicenciatura(_licenciatura);
        setEspecialidad(_especialidad);
        setMaestria(_maestria);
        setDoctorado(_doctorado);
        setEd_tituloLic(_ed_tituloLic);
        setEd_cedulaLic(_ed_cedulaLic);
        setEd_tituloEsp(_ed_tituloEsp);
        setEd_cedulaEsp(_ed_cedulaEsp);
        setEd_tituloMtria(_ed_tituloMtria);
        setEd_cedulaMtria(_ed_cedulaMtria);
        setEd_tituloDoc(_ed_tituloDoc);
        setEd_cedulaDoc(_ed_cedulaDoc);
        setEd_disa(_ed_disa);
        setEd_profordems(_ed_profordems);
        setEd_certidems(_ed_certidems); 
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getLicenciatura() {
        return licenciatura;
    }

    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMaestria() {
        return maestria;
    }

    public void setMaestria(String maestria) {
        this.maestria = maestria;
    }

    public String getDoctorado() {
        return doctorado;
    }

    public void setDoctorado(String doctorado) {
        this.doctorado = doctorado;
    }

    public String getEd_tituloLic() {
        return ed_tituloLic;
    }

    public void setEd_tituloLic(String ed_tituloLic) {
        this.ed_tituloLic = ed_tituloLic;
    }

    public String getEd_cedulaLic() {
        return ed_cedulaLic;
    }

    public void setEd_cedulaLic(String ed_cedulaLic) {
        this.ed_cedulaLic = ed_cedulaLic;
    }

    public String getEd_tituloEsp() {
        return ed_tituloEsp;
    }

    public void setEd_tituloEsp(String ed_tituloEsp) {
        this.ed_tituloEsp = ed_tituloEsp;
    }

    public String getEd_cedulaEsp() {
        return ed_cedulaEsp;
    }

    public void setEd_cedulaEsp(String ed_cedulaEsp) {
        this.ed_cedulaEsp = ed_cedulaEsp;
    }

    public String getEd_tituloMtria() {
        return ed_tituloMtria;
    }

    public void setEd_tituloMtria(String ed_tituloMtria) {
        this.ed_tituloMtria = ed_tituloMtria;
    }

    public String getEd_cedulaMtria() {
        return ed_cedulaMtria;
    }

    public void setEd_cedulaMtria(String ed_cedulaMtria) {
        this.ed_cedulaMtria = ed_cedulaMtria;
    }

    public String getEd_tituloDoc() {
        return ed_tituloDoc;
    }

    public void setEd_tituloDoc(String ed_tituloDoc) {
        this.ed_tituloDoc = ed_tituloDoc;
    }

    public String getEd_cedulaDoc() {
        return ed_cedulaDoc;
    }

    public void setEd_cedulaDoc(String ed_cedulaDoc) {
        this.ed_cedulaDoc = ed_cedulaDoc;
    }

    public String getEd_disa() {
        return ed_disa;
    }

    public void setEd_disa(String ed_disa) {
        this.ed_disa = ed_disa;
    }

    public String getEd_profordems() {
        return ed_profordems;
    }

    public void setEd_profordems(String ed_profordems) {
        this.ed_profordems = ed_profordems;
    }

    public String getEd_certidems() {
        return ed_certidems;
    }

    public void setEd_certidems(String ed_certidems) {
        this.ed_certidems = ed_certidems;
    }

    
   
   
    
    
}
