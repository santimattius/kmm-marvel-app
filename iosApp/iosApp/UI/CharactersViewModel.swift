//
//  CharactersViewModel.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 19/1/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Combine
import shared

final class CharactersViewModel: ObservableObject{
    
    @Published public var characters:[UiCharacter] = []
    
    private let sdk: MarvelSDK
    
    init(sdk:MarvelSDK){
        self.sdk = sdk
    }
    
    func loadCharacters(){
        self.sdk.getCharactersPage(offset: 0, limit: 100, completionHandler: { result, error in
            
            if let currentCharacters = result {
                self.characters = currentCharacters.map{ item in
                    UiCharacter(name: item.name, thumbnail: item.thumbnail, description: item.description_)
                }
           } else {
//               self.launches = .error(error?.localizedDescription ?? "error")
               self.characters = []
           }
            
        })
    }
}
