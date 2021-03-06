package modelo;

import modelo.movimiento.IDireccion;
import modelo.movimiento.Movimiento;
import modelo.posicion.Posicion;

import java.util.function.Consumer;

public abstract class Unidad implements IPosicionable, IAtacable, IMovible {

    protected int vida;
    private Posicion posicion;
    private Movimiento movimiento;

    protected Unidad(Posicion posicion, int vida){
        this.posicion = posicion;
        this.vida = vida;
        this.movimiento = new Movimiento();
    }



    private Consumer<IAtacable> onDestruidoEventHanlder = aldeano -> {};

    public void onDestruido(Consumer<IAtacable> eventHanlder){
        this.onDestruidoEventHanlder = eventHanlder;
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

    @Override // IAtacable
    public void recibirAtaque(IAtacante atacante) {

        int danio = atacante.obtenerDanio(this);

        if(this.vida <= danio){
            this.vida = 0;
            onDestruidoEventHanlder.accept(this);
            return;
        }

        this.vida -= danio;
    }

    @Override
    public int getVida() {
        return vida;
    }
    // fin IAtacable


    @Override
    public void mover(IDireccion direccion){
        movimiento.hacia(direccion);

        this.posicion = movimiento.calcularPosSiguiente(this.posicion);
    }

    public boolean estaEnPosicion(Posicion pos){
        return this.posicion.seSuperponeCon(pos);
    }

    public boolean estaMuerto(){
        return (this.vida == 0);
    }
}
