/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function entrypicked() {
    var x = document.getElementById("combobox_Hersteller");
    var answer= x.options[x.selectedIndex].value;
    var y = document.getElementById("combobox_Modell");
    y.disabled=true;
    document.location.href="/Pages/NewCar1";
    
    return answer;
    }

