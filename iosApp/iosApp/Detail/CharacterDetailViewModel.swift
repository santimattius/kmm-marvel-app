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
    
    @Published public var character: UiCharacter?
    
    private let sdk: MarvelSDK
    
    init(sdk:MarvelSDK){
        self.sdk = sdk
    }
    
    func loadCharacters(id: Int64){
        self.sdk.findCharacterById(id: id, completionHandler: { result, error in
            
            if let currentCharacter = result {
                self.character = UiCharacter(
                    id:currentCharacter.id,
                    name: currentCharacter.name,
                    thumbnail: currentCharacter.thumbnail,
                    description: currentCharacter.description_
                )
           } else {
               //self.character = UiCharacter(id: 1,name: "Error :(", thumbnail: "", description: "")
           }
            
        })
    }
}
