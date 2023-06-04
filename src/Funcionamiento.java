import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Funcionamiento {
    private List<Empleado> listaEmpleados = new ArrayList<>();

    public boolean agregar (Empleado empleado){
        boolean control = false;
        if (searchById(empleado.getCedula())==-1){
            control=true;
            listaEmpleados.add(empleado);
        }
        return control;
    }



    public int searchById(String cedula){
        listaEmpleados.sort(Comparator.comparing(Empleado::getCedula));

        int inicio = 0;
        int tope = listaEmpleados.size() - 1;
        while (inicio <= tope) {
            int medio = (inicio + tope) / 2;
            Empleado em = listaEmpleados.get(medio);
            int comparison = em.getCedula().compareTo(cedula);
            if (comparison == 0) {
                return medio;
            } else if (comparison < 0) {
                inicio = medio + 1;
            } else {
                tope = medio - 1;
            }
        }
        return -1;
    }

    public Empleado imprimirEmpleado (String cedula){
        int posicion = searchById(cedula);
        if (posicion!=-1){
            return listaEmpleados.get(posicion);
        }
        return null;
    }

    public void ModificarEmpleados (String cedula, String Nombre,double sueldo){
        int posicion=searchById(cedula);
        if (posicion!=-1){
            listaEmpleados.get(posicion).setCedula(cedula);
            listaEmpleados.get(posicion).setNombre(Nombre);
            listaEmpleados.get(posicion).setSueldo(sueldo);
            listaEmpleados.get(posicion).setImpuesto(sueldo);
            listaEmpleados.get(posicion).setAporte(sueldo);
            listaEmpleados.get(posicion).setSueldoarecibir(sueldo);
        }
    }

    public void eliminarEmpleado  (String cedula){
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado empleado = listaEmpleados.get(i);
            if (empleado.getCedula().equals(cedula)) {
                listaEmpleados.remove(i);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Lista Empleados\n" + listaEmpleados;
    }
}
