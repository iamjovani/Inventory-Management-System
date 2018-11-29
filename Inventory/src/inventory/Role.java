/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;


/**
 *
 * @author Jovani
 */


public enum Role {
        ADMIN(1), OFFICEMANAGER(0), LABORATORYSTAFF(-1), INFOTECHADMIN(2);
        private int value;

        private Role(int value) {
                this.value = value;
        }
}; 

