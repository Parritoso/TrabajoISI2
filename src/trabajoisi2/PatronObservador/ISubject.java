/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trabajoisi2.PatronObservador;

import trabajoisi2.personas.IPersona;

/**
 *
 * @author eps
 */
public interface ISubject {
    void addObserver(IPersona Observer);				      
    void deleteObserver(IPersona Observer);
    void notifyObservers();

    
}
