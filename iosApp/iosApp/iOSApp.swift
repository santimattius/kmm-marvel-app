import SwiftUI
import Foundation
import shared

@main
struct iOSApp: App {
    
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate
    
	var body: some Scene {
		WindowGroup {
			ContentView(viewModel: CharactersViewModel(sdk: MarvelSDK()))
		}
	}
    
}
