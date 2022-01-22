//
//  Credentials.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 22/1/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation

struct AppCredentials: Decodable {
    private enum CodingKeys: String, CodingKey {
        case marvelPublicKey, marvelPrivateKey
    }

    let marvelPublicKey: String
    let marvelPrivateKey: String

}
