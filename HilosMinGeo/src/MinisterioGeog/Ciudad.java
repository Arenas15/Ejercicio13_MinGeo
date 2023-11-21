package MinisterioGeog;

class Ciudad implements ProyeccionDatos {
    private String nombreCiudad;
    private int cantidadHabitantes;
    private double superficie;

    public Ciudad(String nombreCiudad, int cantidadHabitantes, double superficie) {
        this.nombreCiudad = nombreCiudad;
        this.cantidadHabitantes = cantidadHabitantes;
        this.superficie = superficie;
    }

    @Override
    public double proyeccionHabitantes2030() {
        return cantidadHabitantes * 0.90;
    }

    @Override
    public double superficieOcupada() {
        return superficie + 10000;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public int getCantidadHabitantes() {
        return cantidadHabitantes;
    }

    public double getSuperficie() {
        return superficie;
    }
}