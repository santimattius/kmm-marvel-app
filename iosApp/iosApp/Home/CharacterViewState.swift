//
//  CharacterViewState.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 19/1/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation

enum CharactersViewState {
        case loading
        case result([UiCharacter])
        case error(String)
}
