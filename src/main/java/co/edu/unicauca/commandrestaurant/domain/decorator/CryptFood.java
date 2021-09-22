/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.unicauca.commandRestaurant.infra.Utilities;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan jose
 */
public class CryptFood extends Food{
    
    private Food comidaEncriptada;

    public CryptFood(int prmId, String prmNombre, FoodTypeEnum prmTipo){
        try {
            String nombreEncriptado = Utilities.encriptarComida(prmNombre);
            comidaEncriptada = new Food(prmId, nombreEncriptado, prmTipo);
        } catch (Exception ex) {
            Logger.getLogger(CryptFood.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void setId(int prmID){
        comidaEncriptada.setId(prmID);
    }
    
    @Override
    public void setName(String prmNombre){
        comidaEncriptada.setName(prmNombre);
    }
    
    @Override
    public void setType(FoodTypeEnum prmTipo){
        comidaEncriptada.setType(prmTipo);
    }
    
    @Override
    public int getId(){
        return comidaEncriptada.getId();
    }
    
    @Override
    public String getName(){
        return comidaEncriptada.getName();
    }
    
    @Override
    public FoodTypeEnum getType(){
        return comidaEncriptada.getType();
    }
    
    @Override
    public String toString() {
        return "Food{" + "ID=" + comidaEncriptada.getId() + ", Nombre=" + comidaEncriptada.getName() + ", Tipo=" + comidaEncriptada.getType() + '}';
    }
}
