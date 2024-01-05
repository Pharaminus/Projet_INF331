export function displayText(job_name, job_description){
    let job_intro = "The best job for you is "
    let count_1 = 0;
    let count_2 = 0;
    let count_3 = 0;
    let delay = 100;

    let interval = setInterval(function(){
        if(count_1 < job_intro.length){
            document.getElementById("job-intro").innerHTML += job_intro.charAt(count_1);
            count_1++;
        }
        if(count_1 >= job_intro.length && count_2 < job_name.length){
            document.getElementById("job-name").innerHTML += job_name.charAt(count_2);
            count_2++;
        }
        if(count_2 >= job_name.length && count_3 < job_description.length){
            document.getElementById("job").innerHTML += job_description.charAt(count_3);
            count_3++;
        }
        if(count_3 >= job_description.length){
            clearInterval(interval)
        }
    }, delay)
}
