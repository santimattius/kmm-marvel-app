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
        let appCredentials = readAppCredentials()
        let sdkCredentials = Credentials(publicKey:appCredentials.marvelPublicKey, privateKey:appCredentials.marvelPrivateKey)
        MarvelModuleKt.doInitModule(credentials: sdkCredentials)
        return true
    }
    
    func readAppCredentials() -> AppCredentials {
        let url = Bundle.main.url(forResource: "Credentials", withExtension: "plist")!
        let data = try! Data(contentsOf: url)
        let decoder = PropertyListDecoder()
        return try! decoder.decode(AppCredentials.self, from: data)
    }
}
