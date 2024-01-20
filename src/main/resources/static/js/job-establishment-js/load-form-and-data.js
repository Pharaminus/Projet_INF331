
if (sessionStorage.getItem("click-read-more")) {
    let request = new XMLHttpRequest()
    request.open("GET", "/establishment-api/suggest")

    request.onload = function () {
        if (request.readyState == 4 && request.status) {
            let resp = JSON.parse(request.responseText)
            console.log(resp)
        }
    }
    request.send()
}

function getEstablishmentInfo() {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "/establishment-api/suggested", true)
    xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status === 200) {
            try {
                let response = JSON.parse(xhr.responseText)
                console.log(response)
                establishmentName = response.name
                let establishmentLocation = response.establishmentLocation
                let directorName = response.directorName
                let trainingName = response.trainingName
                establishmentImage = response.establishmentImage
                let trainingCost = response.trainingCost
                let option = response.option
                let domain = response.domain
                let trainingMatterName = response.trainingMatterName
                let trainingMatterLevel = response.trainingMatterLevel
                let trainingMatterCredit = response.trainingMatterCredit

                estabishmentText = "Location: " + establishmentLocation + "<br>" + "Head master: " + directorName + "<br>" + "Formation: " + trainingName
                sessionStorage.setItem("establishment name", establishmentName)
                sessionStorage.setItem("establishment image", establishmentImage)
                sessionStorage.setItem("establishment description", estabishmentText)

                document.getElementById("establishment-image").src = "data:image/webp;base64," + establishmentImage
                document.getElementById("establishment-name").innerHTML = establishmentName
                document.getElementById("establishment-description").innerHTML = estabishmentText
            }
            catch (error) {
                window.location.href = "/login/form"
                // console.log(error)
            }
        }
    }
    xhr.send()
}

function getJobInfo() {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "/job-api/predicted", true)
    xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status === 200) {
            try {
                let response = JSON.parse(xhr.responseText)
                console.log(response)
                jobName = response.name
                description = response.description
                dureeFormation = response.dureeFormation
                jobSalary = response.salary
                jobImage = response.jobImage
                jobOption = response.option

                jobDescription = "In " + jobOption + " sector the " + jobName + " " + description.toLowerCase() + "<br>" + " To become " + jobName + " you need to " + dureeFormation + " years for training, after it you start with " + jobSalary + "FCFA as salary."
                sessionStorage.setItem("job name", jobName)
                sessionStorage.setItem("job image", jobImage)
                sessionStorage.setItem("job description", jobDescription)

                document.getElementById("job-image").src = "data:image/webp;base64," + jobImage;
                document.getElementById("job-tittle").innerHTML = jobName
                document.getElementById("job-description").innerHTML = jobDescription
            }
            catch (error) {
                window.location.href = "/login/form"
                // console.log(error)
            }
        }
    }
    xhr.send()
}

function loadTypeFromDatabase() {
    let xhr = new XMLHttpRequest()
    xhr.open("GET", "/job-api/all-option", true)

    xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            let response = JSON.parse(xhr.responseText)
            response.forEach(result => {
                document.getElementById("type").innerHTML = "<option value='" + result + "'>" + result + "</option>"
            })
        }
    }
    xhr.send()
}

function loadLevelFromDatabase() {
    let xhr = new XMLHttpRequest()
    xhr, open('GET', "/job-api/all-level", true)

    xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            let response = JSON.parse(xhr.responseText)
            response.forEach(result => {
                document.getElementById("niveau").innerHTML = "<option value='" + result + "'>" + result + "</option>"
            })
        }
    }
    xhr.send()
}

if (!sessionStorage.getItem('display')) {
    document.getElementById("job-access").addEventListener('click', () => {
        sessionStorage.setItem('display', true)
        document.getElementById("read-more").style.display = "inline-block";
    })
}
else {
    if (!sessionStorage.getItem("click-read-more")) {
        document.getElementById("read-more").style.display = "inline-block"
    }
    else {
        function extendSection() {
            document.getElementById("read-more").style.display = "none"
            sessionStorage.setItem("click-read-more", true)
        }
    }
}

if (!sessionStorage.getItem("click-access-to")) {
    function checkIfNotesReportExists() {
        let xhr = new XMLHttpRequest()
        xhr.open("GET", "/job-api/check-test", true)

        xhr.onload = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                let response = xhr.responseText
                if (response == "true") {
                    sessionStorage.setItem("click-access-to", true)
                    getEstablishmentInfo()
                    getJobInfo()
                }
                else if (response == "false") {
                    document.getElementById("job-access").setAttribute("data-toggle", "modal")
                    document.getElementById("job-access").setAttribute("data-target", "#popupForm")
                    sessionStorage.setItem("click-access-to", true)
                    getEstablishmentInfo()
                    getJobInfo()
                }
            }
        }
        xhr.send()
    }
}
else {
    function checkIfNotesReportExists() {
        console.log("button have already clicked!")
    }
}

if (sessionStorage.getItem("click-access-to")) {
    document.getElementById("job-image").src = "data:image/webp;base64," + sessionStorage.getItem("job image");
    document.getElementById("job-tittle").innerHTML = sessionStorage.getItem("job name")
    document.getElementById("job-description").innerHTML = sessionStorage.getItem("job description")

    document.getElementById("establishment-image").src = "data:image/webp;base64," + sessionStorage.getItem("establishment image")
    document.getElementById("establishment-name").innerHTML = sessionStorage.getItem("establishment name")
    document.getElementById("establishment-description").innerHTML = sessionStorage.getItem("establishment description")
    document.getElementById("job-access").href = "#job-predicted"
}