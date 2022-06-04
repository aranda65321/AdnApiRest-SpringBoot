# Informacion Api Rest "AdnApiRest-SpringBoot"
AdnApiRest-SpringBoot Api rest para validacion de Adns

##

##Solicitudes permitidas por el servidor

#Solicitud Post Login usuario:

El puerto por defecto del servidor local es 8080 y el de aws es 80
  
Para esta solicitud es necesario enviarle un objeto usuario 
Servidor local: http://localhost:8080/login
Servidor aws: http://ec2-54-226-148-188.compute-1.amazonaws.com:80/login
    
##

#Solicitud Post Crear usuario:
  
Para esta solicitud es necesario enviarle un objeto usuario 
Servidor local: http://localhost:8080/create/user
Servidor aws: http://ec2-54-226-148-188.compute-1.amazonaws.com:80/create/user
    
##

#Solicitud Post Validar Matrix
  
Para esta solicitud es necesario enviarle un objeto matrix
Servidor local: http://localhost:8080/validMatrix
Servidor aws: http://ec2-54-226-148-188.compute-1.amazonaws.com:80/validMatrix
    
##

#Solicitud Get obtener estadisticas
  
Para esta solicitud es necesario enviarle un objeto matrix
Servidor local: http://localhost:8080/statistics
Servidor aws: http://ec2-54-226-148-188.compute-1.amazonaws.com:80/statistics
    
