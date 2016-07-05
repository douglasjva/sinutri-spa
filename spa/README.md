# Setup

```shell
# Baixa os plugins usados no projeto
sh plugins.sh

# Configura algumas propriedades do projeto, como:
#   * Um link para a pasta de fontes no Materialize
sh config.sh
```

# Running

Opean a terminal window or tab, and run:

```shell
sh starter.sh
```

# Guidilines

Use incorporated mode to create services, controllers ...

```javascript
(function() {

    function Controller($dependecies) {
        
        init();
    
        function init() {
        
        }
    
    }
    
    controllers.controller("Controller", Controller);

})();
```

Note, like ```controllers```, there are also ```constants```, ```directives```, ```factories``` and ```services```.