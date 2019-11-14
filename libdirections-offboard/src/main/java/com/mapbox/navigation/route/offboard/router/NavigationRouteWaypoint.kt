package com.mapbox.navigation.route.offboard.router

import com.mapbox.geojson.Point

data class NavigationRouteWaypoint(
    val waypoint: Point,
    val bearingAngle: Double?,
    val tolerance: Double?
)
