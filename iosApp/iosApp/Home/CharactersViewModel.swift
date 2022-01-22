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
    
    @Published public var state: CharactersViewState = .loading
    
    private let sdk: MarvelSDK
    
    init(sdk:MarvelSDK){
        self.sdk = sdk
    }
    
    func loadCharacters(){
        self.sdk.getCharactersPage(offset: 0, limit: 100, completionHandler: { result, error in
            
            if let currentCharacters = result {
                let characters = currentCharacters.map{ item in
                    UiCharacter(id:item.id, name: item.name, thumbnail: item.thumbnail, description: item.description_)
                }
                self.state = .result(characters)
           } else {
               self.state = .error("Characters not received.")
           }
        })
    }
}
