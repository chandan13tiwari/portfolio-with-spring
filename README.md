# Chandan's portfolio using Spring Thymeleaf and JAVA

This portfolio is created using JAVA, SpringBoot and Thymeleaf. 

Portfolio Link - https://portfolio-with-spring.onrender.com

https://portfolio-with-spring-production.up.railway.app/

### You can dynamically change the following content in the portfolio 

###### If you want to add a new Title/Designtion

1. In _PortfolioController.java_, you need to add the new title in 'titles' modelAttribute
2. For CSS changes - follow the instructions given under 'TYPING ANIMATION' section

###### If you want to update the resume

1. I would prefer to use _*.pdf_ as extension to Resume document
2. Rename you resume doc to 'chandan-resume.pdf'

###### If you want to update any links

1. To update any link, you must checkout _Constants.java_

###### If you want to update Year of Experience

1. Goto _Constants.java_, and update the variable 'MY_EXPERIENCE_IN_YEARS'

###### If you want to update 'about me'

1. We have not created 'about me' as a dynamic text, so you can directly update the text from _index.html_

###### If you want to add a new client

1. In _PortfolioController.java_, you need to add a new client in 'clients' modelAttribute
2. Store the client logo under _src/main/resources/static/assets/_ with the proper name formatted as _<client_name>-logo_
3. You can use any of these extension for images - png or jpg
4. Make sure the dimensions of the image should be 400X400

###### If you want to add a new experience

1. We have created different sections for different tech-stack, like frontend, backend, devops, etc. Please add the 
experience under the correct section
2. In _PortfolioController.java_, you need to add the experience accordingly under the following modelAttributes - _frontend, backend, cloud, database, devops_
3. If you want to add a new Tech-stack, then you need to update the structure of the web page a bit, then you can refer _index.html_
4. If you want to add a new Experience level, then you add it in _ExperienceLevel.java_