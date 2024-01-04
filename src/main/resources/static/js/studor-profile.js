let job_intro = "The best job for you is "
let job_name = "Software engeneer."
let job_description = "The job of consist to build Software in several area.\nTo become Software Developer, you need 5 years of training."
let count_1 = 0
let count_2 = 0
let count_3 = 0
let delay = 200

function displayText(){
    if(count_1 < job_intro.length){
        document.getElementById('job-intro').innerHTML += job_intro.charAt(count_1)
        count_1++
        setTimeout(displayText, delay)
    }
    if(count_1 >= job_intro.length && count_2 < job_name.length){
        document.getElementById('job-name').innerHTML += job_name.charAt(count_2)
        count_2++
        setTimeout(displayText, delay)
    }
    if(count_2 >= job_name.length && count_3 < job_description.length){
        console.log(count_2)
        document.getElementById('job').innerHTML += job_description.charAt(count_3)
        count_3++
        setTimeout(displayText, delay)
    }
}

window.onload = displayText