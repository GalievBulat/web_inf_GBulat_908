<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
        <head>
            <meta charset="UTF-8" />
            <title>JSP Application</title>
        </head>
        <body>
            <div>
                <#if errorMessage?has_content>
                    <h2>${errorMessage}</h2>
                </#if>
            </div>
            <div>
                <#if name?has_content>
                    <h2>Hi, ${name}</h2>
                    <h2>login: ${login}</h2>
                    <h2>reg. date: ${reg_date}</h2>
                    <h2>birth day: ${birth_date}</h2>
                </#if>
            </div>
        </body>
    </html>