function jump(lat,lon) {
    var zoom=16;
    var lonLat = new OpenLayers.LonLat( lon, lat )
       .transform(
         new OpenLayers.Projection("EPSG:4326"), // transform from WGS 1984
         map.getProjectionObject() // to Spherical Mercator Projection
       );
    map.setCenter (lonLat, zoom);
 }
 
 function getMarkerLayer(){
     var vectorLayer = new OpenLayers.Layer.Vector("Overlay");
     
     //Loop through the markers array
     for (var i=0; i<markers.length; i++) {
       
        var lat = markers[i][0];
        var lon = markers[i][1];
        
        var centerlonLat = new OpenLayers.LonLat(map.getCenter().lon, map.getCenter().lat).transform(projectTo , epsg4326);
        
        var dist = Math.sqrt(Math.pow(centerlonLat.lat - lat, 2) + Math.pow(centerlonLat.lon - lon, 2));
        
        var factor = Math.min(1/(30*dist),35);
        
         var feature = new OpenLayers.Feature.Vector(
                 new OpenLayers.Geometry.Point( lon, lat ).transform(epsg4326, projectTo),
                 {description: "marker number " + i} ,
                 {externalGraphic: 'images/marker.png', graphicHeight: 25+factor, graphicWidth: 21+factor, graphicXOffset:-12, graphicYOffset:-25  }
             );             
         vectorLayer.addFeatures(feature);
     }
     
     var feature = new OpenLayers.Feature.Vector(
                 new OpenLayers.Geometry.Point( centerlonLat.lon, centerlonLat.lat ).transform(epsg4326, projectTo),
                 {description: "marker number " + i} ,
                 {externalGraphic: 'images/red_cross.jpg', graphicHeight: 10, graphicWidth: 10, graphicXOffset:-12, graphicYOffset:-25  }
             );             
         vectorLayer.addFeatures(feature);
     
     return vectorLayer;
 }

 map = new OpenLayers.Map("mapdiv");
 map.addLayer(new OpenLayers.Layer.OSM());
 
 epsg4326 =  new OpenLayers.Projection("EPSG:4326"); //WGS 1984 projection
 projectTo = map.getProjectionObject(); //The map projection (Spherical Mercator)

 var lonLat = new OpenLayers.LonLat( 35.02005,32.77890 ).transform(epsg4326, projectTo);
       
 var zoom=14;
 map.setCenter (lonLat, zoom);
 
 var vectorLayer = getMarkerLayer();                 
 
 map.addLayer(vectorLayer);
 
 map.events.register("move", map, function() {
         
         map.removeLayer(vectorLayer);
         vectorLayer = getMarkerLayer();		
         map.addLayer(vectorLayer);
         
     });