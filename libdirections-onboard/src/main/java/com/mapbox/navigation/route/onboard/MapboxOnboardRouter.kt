package com.mapbox.navigation.route.onboard

import com.mapbox.annotation.navigation.module.MapboxNavigationModule
import com.mapbox.annotation.navigation.module.MapboxNavigationModuleType
import com.mapbox.geojson.Point
import com.mapbox.navigation.base.route.Router
import com.mapbox.navigation.navigator.MapboxNativeNavigator
import com.mapbox.navigation.navigator.MapboxNativeNavigatorImpl
import java.io.File

@MapboxNavigationModule(MapboxNavigationModuleType.OnboardRouter, skipConfiguration = true)
class MapboxOnboardRouter(private val navigator: MapboxNativeNavigator) : Router {

    companion object {

        private const val TILE_PATH_NAME = "tiles"
    }

    // private val offlineNavigator: OfflineNavigator
    private val tilePath: String
    private val offlineTileVersions: OfflineTileVersions
    private val navigator: MapboxNativeNavigator

    /**
     * Creates an offline router which uses the specified offline path for storing and retrieving
     * data.
     *
     * @param offlinePath directory path where the offline data is located
     */
    constructor(offlinePath: String) {
        val tileDir = File(offlinePath, TILE_PATH_NAME)
        if (!tileDir.exists()) {
            tileDir.mkdirs()
        }

        this.tilePath = tileDir.absolutePath
        offlineTileVersions = OfflineTileVersions()
        this.navigator = MapboxNativeNavigatorImpl
    }

    // Package private for testing purposes
    internal constructor(
        tilePath: String,
        offlineTileVersions: OfflineTileVersions,
        navigator: MapboxNativeNavigator
    ) {
        this.tilePath = tilePath
        this.offlineTileVersions = offlineTileVersions
        this.navigator = navigator
    }

    override fun getRoute(
        origin: Point,
        waypoints: List<Point>?,
        destination: Point,
        callback: Router.RouteCallback
    ) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun cancel() {
        TODO("not implemented")
    }

    class Config {
        fun compile(): String = TODO("not implemented")
    }
}
