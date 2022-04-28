# College Application Automation
This is an application that will check whether a college candidate will be instantly accepted, instantly rejected or need further review.
<br>
There are 4 main criteria to get instantly accepted:
<br>
<h2> Instant accept:</h2>
<ul>
<li> In-state (California) age 17 or older, and younger than 26; or older than 80 from any state.</li>
<li> High School GPA of 90% or higher of scale provided in their application. E.g. 3.6 on a 4.0 scale or 4.5 on a 5.0 scale.</li>
<li> SAT score greater than 1920 or ACT greater than 27. Note: Both or only one may be present in application.</li>
<li> No "instant reject" criteria is hit.</li>
</ul>
<h2> Instant reject</h2>
<ul>
<li> 1 or more felonies over the past 5 years.</li>
<li> High School GPA below 70% of scale provided on application.</li>
<li> The applicant claimed to be a negative age. E.g. "-20" years old.</li>
<li> The applicant first and/or last name are not in the form of first letter capitalized, the rest lower case. </li>
</ul>
<h2> Further review</h2>
<ul>
<li> Store the candidate information. </li>
<li>  Return results to convey "instant accept", "instant reject", "further review". Return plain text descriptions if an applicant is marked for "instant reject".</li>
<li>- Code should be able to handle potential changes and additions to the rules in the future.</li>
</ul>

<h1>How to run the program</h1>
<ol>
<li> Open the project in IntelliJ</li>
<li> Press Run</li>
</ol>
There are 3 different application files that are in the resources file. To change which file to run 
<ol>
<li> Go to the main class file</li>
<li> Change the file that is in this code line </li>
<ul>
<li>        Object application = new JSONParser().parse(new FileReader("src/main/resources/Richard_Luu_application.json"));</li>
</ul>
</ol>
