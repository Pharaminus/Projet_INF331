import { displayText } from "./studor-home.js"


document.getElementById("predict").addEventListener("click", () => {
    let request = new XMLHttpRequest()
    request.open("GET", "/profile-job/check-test", true)

    request.onload = function () {
        if (request.readyState === XMLHttpRequest.DONE && request.status === 200) {
            if (request.responseText == "true") {
                let xhr = new XMLHttpRequest();
                xhr.open("GET", "/profile-job/predicted", true)
                xhr.onload = function () {
                    if (xhr.readyState == XMLHttpRequest.DONE && xhr.status === 200) {
                        try {
                            let response = JSON.parse(xhr.responseText)
                            console.log(response)
                            let name = response.name
                            let description = response.description
                            let dureeFormation = response.dureeFormation
                            let salary = response.salary
                            let jobImage = response.jobImage
                            let option = response.option

                            description = "In " + option + " sector the " + name + " " + description.toLowerCase() + "\n To become " + name + " you need to " + dureeFormation + " years for training, after it you start with " + salary + "FCFA as salary."
                            // window.location.href = "/home/predicted"
                            document.getElementById("image").src = "data:image/webp;base64," + jobImage
                            displayText(name, description)
                        }
                        catch (error) {
                            window.location.href = "/login/form"
                            // console.log(error)
                        }
                    }
                }
                xhr.send()
            }
            else if (request.responseText == "false") {
                document.getElementById("body-contains").style.display = "none";
                document.getElementById("notes-form").style.display = "flex";
            }
        }

    }
    request.send()
})