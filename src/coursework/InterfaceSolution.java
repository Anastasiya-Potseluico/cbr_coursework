/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import jcolibri.cbrcore.Attribute;
import jcolibri.datatypes.Instance;

/**
 *
 * @author Анастасия
 */
public class InterfaceSolution implements jcolibri.cbrcore.CaseComponent {
    public Instance RESULT;
    public Instance WHEEL_CASE;
    @Override
    public Attribute getIdAttribute() {
        return new Attribute("id", this.getClass());
    }
    public Instance getRESULT() {
        return RESULT;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRESULT(Instance result) {
        RESULT = result;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setWheelCase(Instance wheelCase) {
        this.WHEEL_CASE = wheelCase;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Instance getWheelCase() {
        return WHEEL_CASE;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String toString() {
        return "("+ WHEEL_CASE + ";"+ RESULT + ")";
    }
    
}
