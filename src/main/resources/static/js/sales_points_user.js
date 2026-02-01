const map = L.map('map').setView([43.515, 16.45], 12); //prikaz mape na Splitu

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '© OpenStreetMap'
}).addTo(map);

// prolazak kroz sva prodajna mjesta koja dolaze iz backenda
salesPoints.forEach(sp => {
    if (!sp.gpsLat || !sp.gpsLng) return; // ako nema GPS koordinata, preskoči prodajno mjesto

    // kreiranje markera na mapi za prodajno mjesto
    const marker = L.marker([sp.gpsLat, sp.gpsLng]).addTo(map);

    // popup s osnovnim informacijama o prodajnom mjestu
    marker.bindPopup(`
        <div style="min-width:220px">
            <h3 style="margin:0;">${sp.name}</h3>
            <p style="margin:4px 0;">${sp.address ?? ''}</p>
            <hr>
            <b>Radno vrijeme:</b><br>
            ${sp.openingHours ?? '-'}
        </div>
    `);
});
