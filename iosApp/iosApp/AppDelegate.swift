//
//  AppDelegate.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 18/1/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import UIKit
import shared

class AppDelegate: NSObject, UIApplicationDelegate {
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        MarvelModuleKt.doInitModule(credentials:Credentials(publicKey:"c17a941d0c8f54ddcc8bb410bae88856",privateKey:"529b1e011df9f86cfe5439c76353ac3d318b2336"))
        return true
    }
}
