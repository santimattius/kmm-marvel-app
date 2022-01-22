//
//  CharacterDetailViewState.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 22/1/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation

enum CharacterDetailViewState {
    case loading
    case result(UiCharacter)
    case error(String)
}
