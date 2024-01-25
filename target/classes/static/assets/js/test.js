var message = ' Suivre une bonne orientation # Academique, # Professionelle et # Nutritionel.';
var element = document.getElementById("descript");
var i = 0;
var slash = "\\";
function test() {
    if (i == message.length)
        return "ok";
    else {
        setTimeout(() => {

            var elmt = message[i];
            if (elmt == "#") {
                element.innerHTML = element.innerHTML + "<br>";
            }
            else {
                element.innerHTML = element.innerHTML + message[i];
                // element.innerHTML = element.innerHTML + "|";
                element.innerHTML[1] = " q";

            }
            i++;
            test();
            // alert(element.innerHTML[element.innerHTML.length-1])
        }, 200);
    }

}

test();

// function popup(angle) {
//     if (angle == 360) {
//         document.getElementById("popup").style.display = "block";

//         document.getElementById("barre").style.transform = "rotate(360deg)"

//         document.getElementById("boutton").type = "submit";
//         setTimeout(() => {
//             document.getElementById("boutton").type = "button";
//             document.getElementById("popup").style.display = "none";

//             // alert("ok");

//         }, 100);

//         return "ok";

//     }
//     else {

//         setTimeout(() => {
//             // recuPopup(angle+10);
//             angle = angle + 10;
//             var angle2 = "rotate(" + angle + "deg)";
//             // alert(val2);

//             document.getElementById("barre").style.transform = angle2;

//             popup(angle2);
//         }, 400);
//     }
// }

function getProfilPro(){
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/orientationprofessionelle/acceuille', true)
    // xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function () {

        if (xhr.status == 200 && xhr.readyState == 4) {
            alert("ok");
            document.getElementById("html-code").innerHTML = this.responseText;
            alert(this.responseText+"ok test");
            
        }
    }
    xhr.send();
}




