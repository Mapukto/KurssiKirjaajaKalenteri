# KKK rakennekuvaus

KKK:n tekemisessä on kovasti yritetty tehdä MVC -rakennetta. 
Ohjain on ohjelman keskiössä. Ohjain luo KurssiKannan, lukee tallennetut kurssit tiedostoista ja käynnistää UI:n. 

Ohjain ei sisällä itsessään ollenkaan logiikkaa, vaan sen työ on pelkästään ohjata ja toimia rajapintana logiikalle. 

KurssiKanta sisältää kaikki kurssit ja hoitaa niiden hallinnan. 

Näkymiä hallitaan pääasiassa nappien kuuntelijoissa. Kun tiettyjä nappeja painetaan, ne käskevät UI -luokkaa vaihtamaan näkymää. Ohjain on siis pääasiassa kurssikantaa ja kurssien hallintaa varten. 

Uudet kurssit tehdään näkymien kuuntelijoissa jotka pyytävät ohjainta tallentamaan kurssit kurssikantaan.
