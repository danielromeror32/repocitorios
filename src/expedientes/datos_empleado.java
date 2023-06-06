
package expedientes;


public class datos_empleado {
    
    private int id_empleado;
    private String nombre;
    private String fecha_ingreso;
    private String curp;
    private String rfc;
    private int contrato;
    private int tp;
    private String categoria;
    private String tipo_puesto;
    private String centro_costo;
    private String exp_digital_rfc;
    private String exp_digital_curp;
    private String exp_digital_ide;
    
    
    public void setDatosEmpleado (String _id_empleado, String _nombre,String _fecha_ingreso,
            String _curp, String _rfc, String _contrato, String _tp, String _categoria,
            String _tipo_puesto, String _centro_costo, String _exp_digital_rfc, String _exp_digital_curp,
            String _exp_digital_ide){
        
        setId_empleado(Integer.parseInt (_id_empleado));
        setNombre(_nombre);
        setFecha_ingreso (_fecha_ingreso);
        setCurp(_curp);
        setRfc (_rfc);
        setContrato (Integer.parseInt (_contrato));
        setTp (Integer.parseInt (_tp));
        setCategoria(_categoria);
        setTipo_puesto(_tipo_puesto);
        setCentro_costo(_centro_costo);
        setExp_digital_rfc(_exp_digital_rfc);
        setExp_digital_curp(_exp_digital_curp);
        setExp_digital_ide(_exp_digital_ide);
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public int getContrato() {
        return contrato;
    }

    public void setContrato(int contrato) {
        this.contrato = contrato;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo_puesto() {
        return tipo_puesto;
    }

    public void setTipo_puesto(String tipo_puesto) {
        this.tipo_puesto = tipo_puesto;
    }

    public String getCentro_costo() {
        return centro_costo;
    }

    public void setCentro_costo(String centro_costo) {
        this.centro_costo = centro_costo;
    }

    public String getExp_digital_rfc() {
        return exp_digital_rfc;
    }

    public void setExp_digital_rfc(String exp_digital_rfc) {
        this.exp_digital_rfc = exp_digital_rfc;
    }

    public String getExp_digital_curp() {
        return exp_digital_curp;
    }

    public void setExp_digital_curp(String exp_digital_curp) {
        this.exp_digital_curp = exp_digital_curp;
    }

    public String getExp_digital_ide() {
        return exp_digital_ide;
    }

    public void setExp_digital_ide(String exp_digital_ide) {
        this.exp_digital_ide = exp_digital_ide;
    }


    
   
}
