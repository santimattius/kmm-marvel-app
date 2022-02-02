//
//  CharacterDetailViewModel.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 19/1/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Combine
import shared


final class CharacterDetailViewModel:ObservableObject{
    
    @Published public var state:CharacterDetailViewState = .loading
    
    private let sdk: MarvelSDK
    
    init(sdk:MarvelSDK){
        self.sdk = sdk
    }
    
    func loadCharacters(character: UiCharacter, reload: Bool = false){
        if reload {
            self.sdk.findCharacterById(id: character.id, completionHandler: { result, error in
                
                if let currentCharacter = result {
                    let uiCharacter = UiCharacter(
                        id:currentCharacter.id,
                        name: currentCharacter.name,
                        thumbnail: currentCharacter.thumbnail,
                        description: currentCharacter.description_
                    )
                    self.state = .result(uiCharacter)
               } else {
                   self.state = .error("Character not received.")
               }
            })
        } else{
            self.state = .result(character)
        }
    }
}
