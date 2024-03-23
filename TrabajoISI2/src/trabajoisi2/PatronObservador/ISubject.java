/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trabajoisi2.PatronObservador;

/**
 *
 * @author eps
 */
public interface ISubject {
    void addObserver(IObserver Observer);				      
    void deleteObserver(IObserver Observer);
    void notifyObserver();
    void notifyObservers(Object data);
    void notifyObserver(IObserver Observer);
    
}
