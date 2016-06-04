/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import jcolibri.cbrcore.Attribute;

/**
 *
 * @author Анастасия
 */
public class InterfaceSolution implements jcolibri.cbrcore.CaseComponent {
    private String Result;
    private String caseId;
    @Override
    public Attribute getIdAttribute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Object getResult() {
        return Result;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setResult(String text) {
        Result = text;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setId(String text) {
        caseId = text;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
